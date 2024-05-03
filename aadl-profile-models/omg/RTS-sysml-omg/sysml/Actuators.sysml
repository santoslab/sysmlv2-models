package Actuators {
	
	import AADL_Properties::*;
	import AADL_Definitions::*;
	
	part def ActuatorsMockProcess :> Process {
		part actuatorsMockThread : ActuatorsMockThread;
		
        in port tempPressureActuate : DataPort { :> valueType : Base_Types::Boolean; }
		in port saturationActuate : DataPort { :> valueType : Base_Types::Boolean; }
		
		connection tPA : PortConnection connect tempPressureActuate to actuatorsMockThread.tempPressureActuate;
		connection sA : PortConnection connect saturationActuate to actuatorsMockThread.saturationActuate;
	}
	
	part def ActuatorsMockThread :> Thread {
		in port tempPressureActuate : DataPort { :> valueType : Base_Types::Boolean; }
		in port saturationActuate : DataPort { :> valueType : Base_Types::Boolean; }

		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}
	
}