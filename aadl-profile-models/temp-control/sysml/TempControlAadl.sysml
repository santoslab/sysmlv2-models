package TempControlAadl {

	import AADLProperties::*;
	import AADLComponentTypes::*;
	import AADLPortTypes::*;

	
	part tcs : TempControlSystem : System;
	
	// TempControl System (Added purely to conform with the AADL model)
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
	part def TempSensor :> Thread{
		// features
		port ports {
			out currentTemp: Data: Temperature;
			out tempChanged: Event;
		}
		
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}

	// TempControl Thread
	part def TempControl :> Thread {
		// features
		port ports {
			in currentTemp: Data: Temperature;
			in tempChanged: Event;
			out fanCmd: EventData: FanCmd;
			in fanAck: EventData: FanAck;
			in setPoint: EventData: Temperature;
		}
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	// Fan Thread
	part def Fan :> Thread {
		// features
		port ports {
			in fanCmd: EventData: FanCmd;
			out fanAck: EventData: FanAck;
		}
		
		@Properties {
			Dispatch_Protocol = Sporadic;
			Period = 1000;
		}
	}

	// OperatorInterface Thread
	part def OperatorInterface :> Thread {
		// features
		port ports {
			in currentTemp: Data: Temperature;
			out setPoint: EventData: Temperature;
		}
	
		@Properties {
			Dispatch_Protocol = Periodic;
			Period = 1000;
		}
	}

	// Data Types
	part def Temperature :> Base::DataValue {
		attribute degrees : ScalarValues::Integer;
		attribute unit : TempUnit;
	}
	
	enum def TempUnit {
		enum Fahrenheit;
		enum Celsius;
		enum Kelvin;
	}
	
	enum def FanCmd {
		enum On;
		enum Off;
	}
	
	enum def FanAck {
		enum Ok;
		enum Error;
	}

}