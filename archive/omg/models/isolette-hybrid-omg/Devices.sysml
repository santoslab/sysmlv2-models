// Devices.sysml

package Devices {
	
	import Isolette_Data_Model::*;
	import AADL::*;
    import AADL_Project::*;
    import AADL_Project::Time_Units::*;
    	
	//device Detect_Regulator_Failure
	//features
	//  internal_failure : out data port Isolette_Data_Model::Failure_Flag.impl;
	//end Detect_Regulator_Failure;
	//
	//device implementation Detect_Regulator_Failure.impl
	//end detect_regulator_failure.impl;
	//
	//
	//--A.5.2.4 Detect Monitor Failure Function
	//--this is where error models signal active threads an 
	//--internal thermostat monitor failure has been detected
	//device Detect_Monitor_Failure
	//features
	//  internal_failure : out data port Isolette_Data_Model::Failure_Flag.impl;
	//end Detect_Monitor_Failure;
	//
	//device implementation Detect_Monitor_Failure.impl
	//end Detect_Monitor_Failure.impl;
	//
	//device Temperature_Sensor
	//features
	//  air : in data port Isolette_Data_Model::PhysicalTemp.impl;
	//  current_tempWstatus : out data port Isolette_Data_Model::TempWstatus.impl;
	//properties
	//   Dispatch_Protocol => Periodic; -- jab
	//   Period => 1sec; -- jab    
	//end Temperature_Sensor;
	//
	//device implementation Temperature_Sensor.impl
	//end Temperature_Sensor.impl;
	//
	//device Heat_Source
	//features
	//  heat_control : in data port Isolette_Data_Model::On_Off;
	//  heat_out : out data port Isolette_Environment::Heat;
	//properties
	//   Dispatch_Protocol => Periodic; -- jab
	//   Period => 1sec; -- jab  
	//end Heat_Source;
	//
	//device implementation Heat_Source.impl
	//end Heat_Source.impl;
	//-------------------------------------------------------------------------
	// temperature_sensor
	//-------------------------------------------------------------------------
	part def Temperature_Sensor_System :> System {
		
		in port air : DataPort { in :> type : Isolette_Data_Model::PhysicalTemp; }
		out port current_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		
		part cpi : Temperature_Sensor_Process;
		
		connection c1 : PortConnection
			connect air to cpi.air;
		connection c2 : PortConnection
			connect cpi.current_tempWstatus to current_tempWstatus;
	}
	
	part def Temperature_Sensor_Process :> Process {
		
		in port air : DataPort { in :> type : Isolette_Data_Model::PhysicalTemp; }
		out port current_tempWstatus : DataPort { out :> type : Isolette_Data_Model::TempWstatus; }
		
		part thermostat : Temperature_Sensor;
		
		//Connections
		connection c1 : PortConnection
			connect air to thermostat.air;
		connection c2 : PortConnection
			connect thermostat.current_tempWstatus to current_tempWstatus;
	}
	
	part def Temperature_Sensor :> Thread {
		//@Thread_Properties {
		//	Dispatch_Protocol = Periodic;
		//	Period = 1[s];
		//	Stack_Size = Isolette_Properties::StackSize;
		//}
		
		in port air : DataPort { in :> type : Isolette_Data_Model::PhysicalTemp; }
		out port current_tempWstatus : DataPort {in :> type : Isolette_Data_Model::TempWstatus; }
		
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
	}
	
	//-------------------------------------------------------------------------
	// heat_source
	//-------------------------------------------------------------------------
	part def Heat_Source_System :> System {
		
		in port heat_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }
		out port heat_out : DataPort { out :> type : Isolette_Environment::Heat; }
		
		part cpi : Heat_Source_Process;
		
		connection c3 : PortConnection
			connect heat_control to cpi.heat_control;
		connection c4 : PortConnection
			connect cpi.heat_out to heat_out;
	}
	
	part def Heat_Source_Process :> Process {
		
		in port heat_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }
		out port heat_out : DataPort { out :> type : Isolette_Environment::Heat; }
		
		part heat_controller : Heat_Source;
		
		connection c3 : PortConnection
			connect heat_control to heat_controller.heat_control;
		connection c4 : PortConnection
			connect heat_controller.heat_out to heat_out;
	}
	
	part def Heat_Source :>  Thread {
		
		in port heat_control : DataPort { in :> type : Isolette_Data_Model::On_Off; }
		out port heat_out : DataPort { out :> type : Isolette_Environment::Heat; }
		
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
	}
	
	//-------------------------------------------------------------------------
	// detect regulator failure
	//-------------------------------------------------------------------------
	part def Detect_Regulator_Failure_System :> System {
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		part p : Detect_Regulator_Failure_Process;
		
		connection c1 : PortConnection
			connect p.internal_failure to internal_failure;
	}
	
	part def Detect_Regulator_Failure_Process :> Process{
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		part detect_regulator_failure_thread : Detect_Regulator_Failure;
		
		connection c1 : PortConnection
			connect detect_regulator_failure_thread.internal_failure to internal_failure;
	}
	
	part def Detect_Regulator_Failure :> Thread {
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
	}
	
	//-------------------------------------------------------------------------
	// detect monitor failure
	//-------------------------------------------------------------------------
	part def Detect_Monitor_Failure_System :> System {
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		part p : Detect_Monitor_Failure_Process;
		
		connection c1 : PortConnection
			connect p.internal_failure to internal_failure;
	}
	
	part def Detect_Monitor_Failure_Process :> Process {
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		part monitor_failure_thread : Detect_Monitor_Failure;
		
		connection c1 : PortConnection
			connect monitor_failure_thread.internal_failure to internal_failure;
	}
	
	part def Detect_Monitor_Failure :> Thread {
		
		out port internal_failure : DataPort { out :> type : Isolette_Data_Model::Failure_Flag; }
		
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
	}
}