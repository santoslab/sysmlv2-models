package TempControlAadl {

	import AADL_Properties::*;
	import AADL_Definitions_omg::*;
	
	part def TempControlSystem :> System {
		// subcomponents
		part tcp : TempControlProcess;
	}
	
	part def TempControlProcess :> Process {
		// subcomponents
		part tempSensor : TempSensor;
		part tempControl : TempControl;
		part fan : Fan;
		part opInterface : OperatorInterface;
		
		// connections
		connection ctTStoTC : PortConnection connect tempSensor.currentTemp to tempControl.currentTemp;
		connection ctTStoOI : PortConnection connect tempSensor.currentTemp to opInterface.currentTemp;
		connection tcTStoTC : PortConnection connect tempSensor.tempChanged to tempControl.tempChanged;
		connection fcTCtoF : PortConnection connect tempControl.fanCmd to fan.fanCmd;
		connection faFtoTC : PortConnection connect fan.fanAck to tempControl.fanAck;
		connection spOItoTC : PortConnection connect opInterface.setPoint to tempControl.setPoint;
	}
	
	// TempSensor Thread
	part def TempSensor :> Thread {
		// features
		out port currentTemp : DataPort { :> valueType : Temperature; }
		out port tempChanged : EventPort;

		
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}

	part def TempControl :> Thread {
		// features
		in port currentTemp : DataPort { :> valueType : Temperature; }
		in port tempChanged : EventPort;
		out port fanCmd : EventDataPort { :> valueType : FanCmd; }
		in port fanAck : EventDataPort { :> valueType : FanAck; }
		in port setPoint : EventDataPort { :> valueType : SetPoint; }
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	part def Fan :> Thread {
		// features
		in port fanCmd : EventDataPort { :> valueType : FanCmd; }
		out port fanAck : EventDataPort { :> valueType : FanAck; }
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	part def OperatorInterface :> Thread {
		// features
		in port currentTemp : DataPort { :> valueType : Temperature; }
		out port setPoint : EventDataPort { :> valueType : SetPoint; }
	
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}

	// Data Types
	attribute def Temperature {
		attribute degrees : Base_Types::Float_32;
		attribute unit : TempUnit;
	}
	
	attribute def SetPoint {
		attribute low : Temperature;
		attribute high : Temperature;
	}
	
	enum def TempUnit {
		Fahrenheit;
		Celsius;
		Kelvin;
	}
	
	enum def FanCmd {
		On;
		Off;
	}
	
	enum def FanAck {
		Ok;
		Error;
	}
}