package Instrumentation {
	
	import AADL_Properties::*;
	import AADL_Definitions::*;
	
	part def InstrumentationMockProcess :> Process {
		part instrumentationMockThread : InstrumentationMockThread;
		
			// actuation unit 1
		out port unit1_temperatureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
			// actuation unit 2
		out port unit2_temperatureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		
		// actuation unit 1
		connection u1tLc1 : PortConnection connect instrumentationMockThread.unit1_temperatureLogic_channel1 to unit1_temperatureLogic_channel1;
		connection u1tLc2 : PortConnection connect instrumentationMockThread.unit1_temperatureLogic_channel2 to unit1_temperatureLogic_channel2;
		connection u1tLc3 : PortConnection connect instrumentationMockThread.unit1_temperatureLogic_channel3 to unit1_temperatureLogic_channel3;
		connection u1tLc4 : PortConnection connect instrumentationMockThread.unit1_temperatureLogic_channel4 to unit1_temperatureLogic_channel4;
		connection u1pLc1 : PortConnection connect instrumentationMockThread.unit1_pressureLogic_channel1 to unit1_pressureLogic_channel1;
		connection u1pLc2 : PortConnection connect instrumentationMockThread.unit1_pressureLogic_channel2 to unit1_pressureLogic_channel2;
		connection u1pLc3 : PortConnection connect instrumentationMockThread.unit1_pressureLogic_channel3 to unit1_pressureLogic_channel3;
		connection u1pLc4 : PortConnection connect instrumentationMockThread.unit1_pressureLogic_channel4 to unit1_pressureLogic_channel4;
		connection u1sLc1 : PortConnection connect instrumentationMockThread.unit1_saturationLogic_channel1 to unit1_saturationLogic_channel1;
		connection u1sLc2 : PortConnection connect instrumentationMockThread.unit1_saturationLogic_channel2 to unit1_saturationLogic_channel2;
		connection u1sLc3 : PortConnection connect instrumentationMockThread.unit1_saturationLogic_channel3 to unit1_saturationLogic_channel3;
		connection u1sLc4 : PortConnection connect instrumentationMockThread.unit1_saturationLogic_channel4 to unit1_saturationLogic_channel4;
		// actuation unit 2
		connection u2tLc1 : PortConnection connect instrumentationMockThread.unit2_temperatureLogic_channel1 to unit2_temperatureLogic_channel1;
		connection u2tLc2 : PortConnection connect instrumentationMockThread.unit2_temperatureLogic_channel2 to unit2_temperatureLogic_channel2;
		connection u2tLc3 : PortConnection connect instrumentationMockThread.unit2_temperatureLogic_channel3 to unit2_temperatureLogic_channel3;
		connection u2tLc4 : PortConnection connect instrumentationMockThread.unit2_temperatureLogic_channel4 to unit2_temperatureLogic_channel4;
		connection u2pLc1 : PortConnection connect instrumentationMockThread.unit2_pressureLogic_channel1 to unit2_pressureLogic_channel1;
		connection u2pLc2 : PortConnection connect instrumentationMockThread.unit2_pressureLogic_channel2 to unit2_pressureLogic_channel2;
		connection u2pLc3 : PortConnection connect instrumentationMockThread.unit2_pressureLogic_channel3 to unit2_pressureLogic_channel3;
		connection u2pLc4 : PortConnection connect instrumentationMockThread.unit2_pressureLogic_channel4 to unit2_pressureLogic_channel4;
		connection u2sLc1 : PortConnection connect instrumentationMockThread.unit2_saturationLogic_channel1 to unit2_saturationLogic_channel1;
		connection u2sLc2 : PortConnection connect instrumentationMockThread.unit2_saturationLogic_channel2 to unit2_saturationLogic_channel2;
		connection u2sLc3 : PortConnection connect instrumentationMockThread.unit2_saturationLogic_channel3 to unit2_saturationLogic_channel3;
		connection u2sLc4 : PortConnection connect instrumentationMockThread.unit2_saturationLogic_channel4 to unit2_saturationLogic_channel4;
	}
	
	part def InstrumentationMockThread :> Thread {
			// actuation unit 1
		out port unit1_temperatureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_temperatureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_pressureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit1_saturationLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
			// actuation unit 2
		out port unit2_temperatureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_temperatureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_pressureLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel1 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel2 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel3 : DataPort { :> valueType : Base_Types::Boolean; }
		out port unit2_saturationLogic_channel4 : DataPort { :> valueType : Base_Types::Boolean; }

		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}
	
}