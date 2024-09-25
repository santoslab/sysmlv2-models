// Regulate.sysml

package Regulate {
	
	import Isolette_Data_Model::*;
	import AADL::*;
	import AADL_Project::*;
    import AADL_Project::Time_Units::*;
	
	// ===========================================================================================================
    //
    //   R e g u l a t e    T e m p e r a t u r e    P r o c e s s
    //
    // @description process that holds threads that regulate air temperature
    // A.5.1 REGULATE TEMPERATURE FUNCTION
    // 
    // ===========================================================================================================
	
	// process that holds threads that regulate air temperature
	part def Regulate_Temperature :> Process {

		// ===== INPUTs (monitored variables) ...based in part on Figure A.2 and Table A.5 
		//  desired temperature range from operator interface 		
		in port lower_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		in port upper_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		//  actual temperature from temp sensor
		in port current_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		     
		// ===== OUTPUTs (controlled variables)  ...based in part on Figure A.2 and Table A.6
		// status of regulate temperature function as reported to operator interface
		out port regulator_status : DataPort { out :> type : Isolette_Data_Model::Status; }
		// value of current temperature to display on operator interface
		out port displayed_temp : DataPort { out :> type : Isolette_Data_Model::Temp; }
		// actuation command to heater
		out port heat_control : DataPort { out :> type : Isolette_Data_Model::On_Off; }
		
		//thread to manage the interactions between with operator interface and the rest of the regulator process
		part manage_regulator_interface : Manage_Regulator_Interface;
		// thread to manage the heat source.  Receives the desired range, current determine, and determines whether or not to
		//send an on/off command to the heat source
		part manage_heat_source : Manage_Heat_Source;
		//thread to manage the regular mode. Based inputs describing the failure status of the interface, subsystem internals,
		//and temperature  status,  determines the mode of the regulator process (i.e., if the mode is Init, Normal, or Failed modes)
		part manage_regulator_mode : Manage_Regulator_Mode;
		
		// ==== INPUT INTERFACE values to internal components ==== 		
	    // send incoming desired temperature range to regulator interface manager
	    connection rudt : PortConnection
	    	connect upper_desired_tempWstatus to manage_regulator_interface.upper_desired_tempWstatus;
	    connection rldt : PortConnection
	    	connect lower_desired_tempWstatus to manage_regulator_interface.lower_desired_tempWstatus;
	
	    // send incoming current temperature (with status value)
	    //   ...to interface manager
	    connection rcti : PortConnection 
	    	connect current_tempWstatus to manage_regulator_interface.current_tempWstatus;
	    //   ...and to heat source manager
	    connection rcth : PortConnection 
			connect current_tempWstatus to manage_heat_source.current_tempWstatus;
	    //   ...and to mode manager
	    connection rctm : PortConnection
	    	connect current_tempWstatus to manage_regulator_mode.current_tempWstatus;
	   
	    // ==== OUTPUT INTERFACE values from internal components ==== 
	    // output temperature to display on operator interface
	    connection rdt : PortConnection
			connect manage_regulator_interface.displayed_temp to displayed_temp;
	    // output regulator subsystem status to operator interface  
	    connection rrs : PortConnection
			connect manage_regulator_interface.regulator_status to regulator_status;
	    // output on/off command to heat source
	    connection rhc : PortConnection
	    	connect manage_heat_source.heat_control to heat_control;
	  
	    // ==== INTERNAL communication ====
	    // send validated desired temperature from interface manager to heat source manager
	    connection mudt : PortConnection 
			connect manage_regulator_interface.upper_desired_temp to manage_heat_source.upper_desired_temp;
	    connection mldt : PortConnection
	   		connect manage_regulator_interface.lower_desired_temp to manage_heat_source.lower_desired_temp;
	  
	    // send regulator mode from mode manager 
	    //  ... to interface manager
	    connection rrmi : PortConnection 
	    	connect manage_regulator_mode.regulator_mode to manage_regulator_interface.regulator_mode;
	    //  ... and to heat source manager
	    connection rrmh : PortConnection 
	    	connect manage_regulator_mode.regulator_mode to manage_heat_source.regulator_mode;
	
	    // send regulator interface failure to mode manager
	    connection rif : PortConnection
	    	connect manage_regulator_interface.interface_failure to manage_regulator_mode.interface_failure;

	}
	
	// ===========================================================================================================
	//
	//   M a n a g e    R e g u l a t o r   I n t e r f a c e   T h r e a d
	//
	//  
	// A.5.1.1 Manage Regulator Interface Function
	// 
	// ===========================================================================================================

	part def Manage_Regulator_Interface :> Thread {
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
		
		// ==== INPUTS ====	(see Figure A.3)
	    //  desired temperature from operator interface
	    in port upper_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
	    in port lower_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
  	    // current temperature from temp sensor
	    in port current_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
	    // current mode of regulator subsystem
	    in port regulator_mode : DataPort { in :> type : Isolette_Data_Model::Regulator_Mode; }
	  
	    // ==== OUTPUTS ====	(see Figure A.3)
	    // validated ("valid" status confirmed) desired temperature range from operator interface
	    out port upper_desired_temp : DataPort { out :> type : Isolette_Data_Model::Temp; }
	    out port lower_desired_temp : DataPort { out :> type : Isolette_Data_Model::Temp; }
	    // current temperature to display on operator interface
	    out port displayed_temp : DataPort { out :> type : Isolette_Data_Model::Temp; }
	    // overall status of regulator subsystem sent to operator interface
	    out port regulator_status : DataPort { out :> type : Isolette_Data_Model::Status; }
	    // flag indicating improper inputs; sent to determine overall subsystem mode 
	    out port interface_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }

		language "GUMBO" /*{
			// specification helper function
			functions
				def ROUND(num:Base_Types::Float_32):Base_Types::Float_32 := num;
			
			//  ====== I n i t i a l i z e    E n t r y    P o i n t    Behavior Constraints ======
			initialize
				guarantee
					RegulatorStatusIsInitiallyInit: regulator_status == Isolette_Data_Model::Status.Init_Status;
			
			//  ====== C o m p u t e    E n t r y    P o i n t   Behavior Constraints =====
			compute
				// general assumption between incoming port values    
				assume lower_is_not_higher_than_upper: lower_desired_tempWstatus.value <= upper_desired_tempWstatus.value;
			
				compute_cases
					// ====== Regulator Status ======    
			
					case REQ_MRI_1 "If the Regulator Mode is INIT,
									|the Regulator Status shall be set to Init.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=107 ":
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Init_Regulator_Mode;
						guarantee regulator_status == Isolette_Data_Model::Status.Init_Status;
			
					case REQ_MRI_2 "If the Regulator Mode is NORMAL,
									|the Regulator Status shall be set to On
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=107 ":
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode;
						guarantee regulator_status == Isolette_Data_Model::Status.On_Status;
			
					case REQ_MRI_3 "If the Regulator Mode is FAILED,
									|the Regulator Status shall be set to Failed.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=107 ":
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode;
						guarantee regulator_status == Isolette_Data_Model::Status.Failed_Status;
			
					// ===== Display Temperature =====
			
					case REQ_MRI_4 "If the Regulator Mode is NORMAL, the
									|Display Temperature shall be set to the value of the
									|Current Temperature rounded to the nearest integer.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ":
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode;
						guarantee displayed_temp.value == ROUND(current_tempWstatus.value);
			
					case REQ_MRI_5 "If the Regulator Mode is not NORMAL,
									|the value of the Display Temperature is UNSPECIFIED.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ": 
						assume T;
						guarantee T;

					// ===== Regulator Interface Failure =====
			
					case REQ_MRI_6 "If the Status attribute of the Lower Desired Temperature
									|or the Upper Desired Temperature is Invalid,
									|the Regulator Interface Failure shall be set to True.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ":
						assume ((upper_desired_tempWstatus.status != Isolette_Data_Model::ValueStatus.Valid) | (upper_desired_tempWstatus.status != Isolette_Data_Model::ValueStatus.Valid));
						guarantee interface_failure.value;
			
					case REQ_MRI_7 "If the Status attribute of the Lower Desired Temperature
									|and the Upper Desired Temperature is Valid,
									|the Regulator Interface Failure shall be set to False.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ":
						assume T;
						guarantee (interface_failure.value == (not((upper_desired_tempWstatus.status == Isolette_Data_Model::ValueStatus.Valid) & (lower_desired_tempWstatus.status == Isolette_Data_Model::ValueStatus.Valid))));
			
					// ===== Desired Range =====
			
					case REQ_MRI_8 "If the Regulator Interface Failure is False
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ":
					    assume T;
						guarantee 
							'->:' (not interface_failure.value, 
								  (lower_desired_temp.value == lower_desired_tempWstatus.value) & (upper_desired_temp.value == upper_desired_tempWstatus.value));
					
					case REQ_MRI_9 "If the Regulator Interface Failure is True,
									|the Desired Range is UNSPECIFIED.
									|the Desired Range shall be set to the Desired Temperature Range.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=108 ":
						assume T;
						guarantee T;
		}*/	    
	}
	
	// ===========================================================================================================
	//
	//   M a n a g e    R e g u l a t o r   M o d e   T h r e a d
	//
	//  
	//   A.5.1.2 Manage Regulator Mode Function
	// 
	// ===========================================================================================================

	part def Manage_Regulator_Mode :> Thread {
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
		
		// ==== INPUTS ========		
  	  	// current temperature from temp sensor
  		in port current_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
  		// status of operator interface interactions
  		in port interface_failure : DataPort { in :> type : Isolette_Data_Model::Failure_Flag; }
  		// internal status of regulator
  		in port internal_failure : DataPort { in :> type : Isolette_Data_Model::Failure_Flag; }
  
  		// ==== OUTPUTS ========		
  		// mode of regulator (Init, Normal, Failed)
  		out port regulator_mode : DataPort { out :> type : Isolette_Data_Model::Regulator_Mode; }

		language "GUMBO" /*{
			// indicate that the component maintains an internal state (variables) that influence it's behavior
			state
				lastRegulatorMode: Isolette_Data_Model::Regulator_Mode;

			// Note: In AR-08-32, requirements for Manage Regulator Mode are not given in natural language clauses,
			//       but instead are phrased in terms of a state machine.  We interpret the state machine transitions
			//       as natural language clauses in the comments below.
			
			//  ======= I n i t i a l i z e    E n t r y    P o i n t    Behavior Constraints  ======
			initialize
				guarantee REQ_MRM_1 "The initial mode of the regular is INIT
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109 " :
					regulator_mode == Isolette_Data_Model::Regulator_Mode.Init_Regulator_Mode; 

			//  ======= C o m p u t e   E n t r y    P o i n t    Behavior Constraints  ======
			compute
				compute_cases
			
					case REQ_MRM_2 "'transition from Init to Normal'
									|If the current regulator mode is Init, then
									|the regulator mode is set to NORMAL iff the regulator status is valid (see Table A-10), i.e.,
									|  if NOT (Regulator Interface Failure OR Regulator Internal Failure)
									|     AND Current Temperature.Status = Valid
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109 ":
						assume lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Init_Regulator_Mode;
						guarantee 
							((not(interface_failure.value or internal_failure.value)) and 
								current_tempWstatus.status == Isolette_Data_Model::ValueStatus.Valid) implies
							(regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode and
								lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode);
			
					case REQ_MRM_Maintain_Normal "'maintaining NORMAL, NORMAL to NORMAL'
												|If the current regulator mode is Normal, then
												|the regulator mode is stays normal iff
												|the regulaor status is not false i.e.,
												|       if NOT(
												|           (Regulator Interface Failure OR Regulator Internal Failure)
												|           OR NOT(Current Temperature.Status = Valid)
												|       )
												|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109 ":
						assume lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode;
						guarantee 
							((not(interface_failure.value or internal_failure.value)) and 
								current_tempWstatus.status == Isolette_Data_Model::ValueStatus.Valid) implies
							(regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode and
								lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode);
							 	        
					case REQ_MRM_3 "'transition for NORMAL to FAILED'
									|If the current regulator mode is Normal, then
									|the regulator mode is set to Failed iff
									|the regulator status is false, i.e.,
									|   if  (Regulator Interface Failure OR Regulator Internal Failure)
									|       OR NOT(Current Temperature.Status = Valid)
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109 ":
						assume lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode;
						guarantee 
							((interface_failure.value or internal_failure.value) and
								current_tempWstatus.status != Isolette_Data_Model::ValueStatus.Valid) implies
							(regulator_mode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode and
								lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode);
			
					case REQ_MRM_4 "'transition from INIT to FAILED' 
									|If the current regulator mode is Init, then
									|the regulator mode and lastRegulatorMode state value is set to Failed iff
									|the regulator status is false, i.e.,
									|       if  (Regulator Interface Failure OR Regulator Internal Failure)
									|       OR NOT(Current Temperature.Status = Valid)
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109":
						assume lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Init_Regulator_Mode;
						guarantee 
							((interface_failure.value or internal_failure.value) and 
								current_tempWstatus.status != Isolette_Data_Model::ValueStatus.Valid) implies
							(regulator_mode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode and
								lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode);
			
					case REQ_MRM_MaintainFailed "'maintaining FAIL, FAIL to FAIL'
												|If the current regulator mode is Failed, then
												|the regulator mode remains in the Failed state and the LastRegulator mode remains Failed.REQ-MRM-Maintain-Failed
												|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=109":
						assume lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode;
						guarantee (regulator_mode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode and
							lastRegulatorMode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode);
		}*/  		
	}
	
	// ===========================================================================================================
	//
	//   M a n a g e    H e a t    S o u r c e     T h r e a d
	//
	//  
	//    A.5.1.3 Manage Heat Source Function
	// 
	// ===========================================================================================================
	
	part def Manage_Heat_Source :> Thread {
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
		
		// ======== INPUTS =======
		// current temperature (from temp sensor)
		in port current_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		// lowest and upper bound of desired temperature range
 		in port lower_desired_temp : DataPort { in :> type : Isolette_Data_Model::Temp; }
		in port upper_desired_temp : DataPort { in :> type : Isolette_Data_Model::Temp; }
		// subsystem mode 
 		in port regulator_mode : DataPort { in :> type : Isolette_Data_Model::Regulator_Mode; }
    
		// ======== OUTPUTS =======
		// command to turn heater on/off (actuation command)
  		in port heat_control : DataPort { out :> type : Isolette_Data_Model::On_Off; }
  		
		language "GUMBO" /*{
			// indicate that the component maintains an internal state (variables) that influence its behavior
			state
				lastCmd: Isolette_Data_Model::On_Off;
			
			//  ======= I n i t i a l i z e    E n t r y    P o i n t    Behavior Constraints  ======
			initialize
				guarantee
					initlastCmd: lastCmd == Isolette_Data_Model::On_Off.Off;
				guarantee REQ_MHS_1 "If the Regulator Mode is INIT, the Heat Control shall be
									|set to Off
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=110 ":
					heat_control == Isolette_Data_Model::On_Off.Off;
			
			//  ====== C o m p u t e    E n t r y    P o i n t   Behavior Constraints =====      
			compute
				// assumption on set points enforced within the Operator Interface
				assume lower_is_lower_temp: lower_desired_temp.value <= upper_desired_temp.value;
			
				// the lastCmd state variable is always equal to the value of the heat_control output port
				guarantee lastCmd "Set lastCmd to value of output Cmd port":
					lastCmd == heat_control;
			
				compute_cases
			
					case REQ_MHS_1 "If the Regulator Mode is INIT, the Heat Control shall be
									|set to Off.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=110 ": 
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Init_Regulator_Mode;
						guarantee heat_control == Isolette_Data_Model::On_Off.Off;
			
					case REQ_MHS_2 "If the Regulator Mode is NORMAL and the Current Temperature is less than
									|the Lower Desired Temperature, the Heat Control shall be set to On.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=110 ":
						assume (regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode)
							& (current_tempWstatus.value < lower_desired_temp.value);
						guarantee heat_control == Isolette_Data_Model::On_Off.Onn;
			
					case REQ_MHS_3 "If the Regulator Mode is NORMAL and the Current Temperature is greater than
									|the Upper Desired Temperature, the Heat Control shall be set to Off.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=110 ":
						assume (regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode)
							& (current_tempWstatus.value > upper_desired_temp.value);
						guarantee heat_control == Isolette_Data_Model::On_Off.Off;
			
					case REQ_MHS_4 "If the Regulator Mode is NORMAL and the Current
								|Temperature is greater than or equal to the Lower Desired Temperature
								|and less than or equal to the Upper Desired Temperature, the value of
								|the Heat Control shall not be changed.
								|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=110 ":
						assume (regulator_mode == Isolette_Data_Model::Regulator_Mode.Normal_Regulator_Mode)
							& (current_tempWstatus.value >= lower_desired_temp.value
							& current_tempWstatus.value <= upper_desired_temp.value); 
						guarantee heat_control == In(lastCmd);
			
					case REQ_MHS_5 "If the Regulator Mode is FAILED, the Heat Control shall be
									|set to Off.
									|http://pub.santoslab.org/high-assurance/module-requirements/reading/FAA-DoT-Requirements-AR-08-32.pdf#page=111 ":
						assume regulator_mode == Isolette_Data_Model::Regulator_Mode.Failed_Regulator_Mode;
						guarantee heat_control == Isolette_Data_Model::On_Off.Off;
		}*/
	}
	
}