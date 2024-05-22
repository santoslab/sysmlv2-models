package EventControl {
	
	import AADL_Properties::*;
	import AADL_Definitions_omg::*;
	
	part def EventControlMockProcess :> Process {
		part eventControlMockThread : EventControlMockThread;
		
		out port manualActuatorInput1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port manualActuatorInput2 : DataPort { :> valueType : Base_Types::Boolean; }
		
		connection mAI1 : PortConnection connect eventControlMockThread.manualActuatorInput1 to manualActuatorInput1;
		connection mAI2 : PortConnection connect eventControlMockThread.manualActuatorInput2 to manualActuatorInput2;
	}
	
	part def EventControlMockThread :> Thread {
		out port manualActuatorInput1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port manualActuatorInput2 : DataPort { :> valueType : Base_Types::Boolean; }
		
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}
	
}