// Isolette.sysml
//
// =====================================================================================================================
//
//   I s o l e t t e     P a c k a g e 
// 
//
//   Top-level system specification including
//
//      - thermostat + temp sensor and heater hardware components
//      - system boundary capturing interactions with the environment
//
// =====================================================================================================================
 
// authors Brian Larson and John Hatcliff
// translated to SysMLv2 by Clint McKenzie

package Isolette {
	
	import Isolette_Data_Model::*;
	import Regulate::*;
	import Monitor::*;
	import AADL::*;
	import AADL_Project::*;
    import AADL_Project::Time_Units::*;
    
	// top-level system component representing the Isolette
	part def Isolette :> System {
		
		// Subcomponents
		
		part thermostat : Thermostat_Single_Sensor;
		
		part operator_interface : Operator_Interface;
		
		part temperature_sensor : Devices::Temperature_Sensor_System;
		
		part heat_source : Devices::Heat_Source_System;
		
		part isolette_processor: Isolette_Processor;
		
		part isolette_process: Isolette_Process;
		
		// Ports
		
		// models (abstractly) warming of air inside of Isolette enclosure
		out port heat_out : DataPort { out :> type : Isolette_Environment::Heat; }
		// models (abstractly) commands given by the operator to Isolette operator interface
		in port operator_commands : DataPort { in :> type : Isolette_Environment::Interface_Interaction; }
		// models (abstractly) visual information presented to the operator on Isolette operator interface
		out port operator_visual_information : DataPort { out :> type : Isolette_Environment::Interface_Interaction; }
		// models (abstraction) audio information presented to the operator on Isolette operator interface
		out port operator_alarm : DataPort { out :> type : Isolette_Environment::Interface_Interaction; }
		// models (abstractly) the sensing of the physical air temperature
		in port air_temperature : DataPort { in :> type : Isolette_Data_Model::PhysicalTemp; }
		
		// Connections
		
		// ==== INPUT interface to internal components ==== 	    
		// commands from operator flow into the operator interface
		connection oioc : PortConnection
			connect operator_commands to operator_interface.operator_commands;
		// the environment air temperature (abstract/physical) flows into the temp sensor
		connection a2ts : PortConnection
			connect air_temperature to temperature_sensor.air;

		// ==== OUTPUT interface values from internal components ==== 
		// information (audio and visual) flows from the operator interface to the operator
		connection oiovi : PortConnection
			connect operator_interface.operator_visual_information to operator_visual_information;
		connection oioa : PortConnection
			connect operator_interface.operator_alarm to operator_alarm;

		// heat source's (abstract) output is increase in physical air temperature
		connection hs : PortConnection
			connect heat_source.heat_out to heat_out;

		// ==== INTERNAL communication ==== 
		// sensor sends sensed current temperature to thermostat  
		connection ct : PortConnection
			connect temperature_sensor.current_tempWstatus to thermostat.current_tempWstatus;
		
		// thermostat controls turns the heat source off and on  
		connection hc : PortConnection
			connect thermostat.heat_control to heat_source.heat_control;

		// operator interface communicates desired temperature to thermostat
		connection ldt : PortConnection
			connect operator_interface.lower_desired_tempWstatus to thermostat.lower_desired_tempWstatus;
		connection udt : PortConnection
			connect operator_interface.upper_desired_tempWstatus to thermostat.upper_desired_tempWstatus;

		// operator interface communicates alarm temperature to thermostat
		connection lat : PortConnection
			connect operator_interface.lower_alarm_tempWstatus to thermostat.lower_alarm_tempWstatus;
		connection uat : PortConnection
			connect operator_interface.upper_alarm_tempWstatus to thermostat.upper_alarm_tempWstatus;

		// thermostat communicates regulator status to display on operator interface
		connection rs : PortConnection
			connect thermostat.regulator_status to operator_interface.regulator_status;
		// thermostat communicates monitor status to display on operator interface
		connection ms : PortConnection
			connect thermostat.monitor_status to operator_interface.monitor_status;
		// thermostat communicates current sensed temperature to display on operator interface
		connection dt : PortConnection
			connect thermostat.display_temperature to operator_interface.display_temperature;
		// thermostat communicates alarm information to display on operator interface
		connection al : PortConnection
			connect thermostat.alarm_control to operator_interface.alarm_control;
	}
	
	part def Isolette_Processor :> Processor {
	}

	part def Isolette_Process :> Process{
	}
	
	// =====================================================================================================================
	//
	//   T h e r m o s t a t 
	// 
	//   See Section A-5 and Figure A-2
	//
	// =====================================================================================================================
	// See Figure A-2 for overall architecture and Tables A-4, A-5, and A-6 for data descriptions
	
	part def Thermostat_Single_Sensor :> System {
		
		// ======== INPUTS =======
		// receive current temperature (with status info) from temp sensor
		in port current_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		// receive desired temperature range (with status info) from operator interface
		in port lower_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		in port upper_desired_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		// receive alarm temperature range (with status info) from operator interface
		in port lower_alarm_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }
		in port upper_alarm_tempWstatus : DataPort { in :> type : Isolette_Data_Model::TempWstatus; }

		// ======== OUTPUTS =========
		// send heat control command to heat source 
		out port heat_control: DataPort  { out :> type : Isolette_Data_Model::On_Off; }
		// send information to operator interface
		out port regulator_status : DataPort { out :> type : Isolette_Data_Model::Status; }
		out port monitor_status : DataPort { out :> type : Isolette_Data_Model::Status; }
		out port display_temperature : DataPort { out :> type : Isolette_Data_Model::Temp; }
		out port alarm_control : DataPort { out :> type : Isolette_Data_Model::On_Off; }
		
		part regulate_temperature : Regulate::Regulate_Temperature;
		part monitor_temperature : Monitor::Monitor_Temperature;
		
		// ==== INPUT interface to internal components ====
		// current temperature from temp sensor 	
		connection tctm: PortConnection
			connect current_tempWstatus to monitor_temperature.current_tempWstatus;
		connection tctr: PortConnection
			connect current_tempWstatus to regulate_temperature.current_tempWstatus;
		// desired temperature range
		connection tudt: PortConnection
			connect upper_desired_tempWstatus to regulate_temperature.upper_desired_tempWstatus;
		connection tldt: PortConnection
			connect lower_desired_tempWstatus to regulate_temperature.lower_desired_tempWstatus;
		// alarm temperature range
		connection tuat: PortConnection
			connect upper_alarm_tempWstatus to monitor_temperature.upper_alarm_tempWstatus;
		connection tlat: PortConnection
			connect lower_alarm_tempWstatus to monitor_temperature.lower_alarm_tempWstatus;

		// ==== OUTPUT interface from internal components ==== 	
		// display temperature
		connection tdt: PortConnection
			connect regulate_temperature.displayed_temp to display_temperature;
		// subsystem status
		connection trs: PortConnection
			connect regulate_temperature.regulator_status to regulator_status;
		connection tms : PortConnection
			connect monitor_temperature.monitor_status to monitor_status;
		// alarm control
		connection ta : PortConnection
			connect monitor_temperature.alarm_control to alarm_control;
		// heat control
		connection thc: PortConnection
			connect regulate_temperature.heat_control to heat_control;

	}
	
	// =====================================================================================================================
	//
	//   O p e r a t o r     I n t e r f a c e
	// 
	//   See Section A-5 and Figure A-2
	//
	// =====================================================================================================================

	part def Operator_Interface :> System {
		
		// ======== INPUT from Operator to Operator Interface =======		
		in port operator_commands : DataPort { in :> type : Isolette_Environment::Interface_Interaction; }
		// ======== OUTPUT from Operator Interface to Operator  =======	
		// models (abstractly) visual information presented to the operator on Isolette operator interface
		out port operator_visual_information : DataPort { out :> type : Isolette_Environment::Interface_Interaction; }
		// models (abstraction) audio information presented to the operator on Isolette operator interface
		out port operator_alarm : DataPort { out :> type : Isolette_Environment::Interface_Interaction; }
		// models (abstractly) the sensing of the physical air temperature
		// ==== INPUTS from thermostat to operator interface 
		in port regulator_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port monitor_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port display_temperature : DataPort { in :> type : Isolette_Data_Model::Temp; }
		in port alarm_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }

		// ==== OUTPUTS from operator interface to thermostat 
		out port lower_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port lower_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		
		part oip : Operator_Interface_Process;
		
		connection c1: PortConnection
			connect regulator_status to oip.regulator_status;
		connection c2: PortConnection
			connect monitor_status to oip.monitor_status;
		connection c3: PortConnection
			connect display_temperature to oip.display_temperature;
		connection c4: PortConnection
			connect alarm_control to oip.alarm_control;

		connection c5: PortConnection
			connect oip.lower_desired_tempWstatus to lower_desired_tempWstatus;
		connection c6: PortConnection
			connect oip.upper_desired_tempWstatus to upper_desired_tempWstatus;
		connection c7: PortConnection
			connect oip.lower_alarm_tempWstatus to lower_alarm_tempWstatus;
		connection c8: PortConnection
			connect oip.upper_alarm_tempWstatus to upper_alarm_tempWstatus;
	}
	
	part def Operator_Interface_Process :> Process {
		
		// ==== INPUTS from thermostat to operator interface
		in port regulator_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port monitor_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port display_temperature : DataPort { in :> type : Isolette_Data_Model::Temp; }
		in port alarm_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }

		// ==== OUTPUTS from operator interface to thermostat 
		out port lower_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port lower_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		
		part oit : Operator_Interface_Thread;
		
		connection c1: PortConnection
			connect regulator_status to oit.regulator_status;
		connection c2: PortConnection
			connect monitor_status to oit.monitor_status;
		connection c3: PortConnection
			connect  display_temperature to oit.display_temperature;
		connection c4: PortConnection
			connect alarm_control to oit.alarm_control;

		connection c5: PortConnection
			connect oit.lower_desired_tempWstatus to lower_desired_tempWstatus;
		connection c6: PortConnection
			connect oit.upper_desired_tempWstatus to upper_desired_tempWstatus;
		connection c7: PortConnection
			connect oit.lower_alarm_tempWstatus to lower_alarm_tempWstatus;
		connection c8: PortConnection
			connect oit.upper_alarm_tempWstatus to upper_alarm_tempWstatus;
	}
	
	part def Operator_Interface_Thread :> Thread {
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
		
		// ==== INPUTS from thermostat to operator interface
		in port regulator_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port monitor_status : DataPort { in :> type : Isolette_Data_Model::Status; }
		in port display_temperature : DataPort { in :> type : Isolette_Data_Model::Temp; }
		in port alarm_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }

		// ==== OUTPUTS from operator interface to thermostat 
		out port lower_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_desired_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port lower_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		out port upper_alarm_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
	}
}