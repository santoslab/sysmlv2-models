package TempControlAadl {

	import AADL_Properties::*;
	import AADL_Definitions::*;
	
	part tcs : TempControlSystem : System;
	
	part def TempControlSystem :> System {
		// subcomponents
		part tcp : TempControlProcess : Process;
	}
	
	part def TempControlProcess :> Process {
		// subcomponents
		part tempSensor : TempSensor : Thread;
		part tempControl : TempControl : Thread;
		part fan : Fan : Thread;
		part opInterface : OperatorInterface : Thread;
		
		// connections
		connection ctTStoTC connect tempSensor.ports.currentTemp to tempControl.ports.currentTemp;
		connection ctTStoOI connect tempSensor.ports.currentTemp to opInterface.ports.currentTemp;
		connection tcTStoTC connect tempSensor.ports.tempChanged to tempControl.ports.tempChanged;
		connection fcTCtoF connect tempControl.ports.fanCmd to fan.ports.fanCmd;
		connection faFtoTC connect fan.ports.fanAck to tempControl.ports.fanAck;
		connection spOItoTC connect opInterface.ports.setPoint to tempControl.ports.setPoint;
	}
	
	// TempSensor Thread
	part def TempSensor :> Thread {
		// features
		port ports {
			out currentTemp: DataPort: Temperature;
			out tempChanged: EventPort;
		}
		
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}

	part def TempControl :> Thread {
		// features
		port ports {
			in currentTemp: DataPort: Temperature;
			in tempChanged: EventPort;
			out fanCmd: EventDataPort: FanCmd;
			in fanAck: EventDataPort: FanAck;
			in setPoint: EventDataPort: SetPoint;
		}
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	part def Fan :> Thread {
		// features
		port ports {
			in fanCmd: EventDataPort: FanCmd;
			out fanAck: EventDataPort: FanAck;
		}
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	part def OperatorInterface :> Thread {
		// features
		port ports {
			in currentTemp: DataPort: Temperature;
			out setPoint: EventDataPort: SetPoint;
		}
	
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