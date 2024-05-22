package TempControlAadl {

    import AADL::*;
    import AADL_Project::*;
    import AADL_Project::Time_Units::*;
	
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
		out port currentTemp : DataPort { out :> type : Temperature; }
		out port tempChanged : EventPort;
	
		attribute :>> Dispatch_Protocol = Periodic;
		attribute :>> Period = 1000 [ms];
		
		//@Properties {
		//	Dispatch_Protocol = Periodic;
		//	Period = 1000;
		//}
	}

	part def TempControl :> Thread {
		// features
		port currentTemp : DataPort { in :> type : Temperature; }
		
		// EventPort does not have an item usage with visiblity rules.
		in port tempChanged : EventPort;
		
		out port fanCmd : EventDataPort { out :> type : FanCmd; }
		in port fanAck : EventDataPort { in :> type : FanAck; }
		in port setPoint : EventDataPort { in :> type : SetPoint; }
		
		attribute :>> Dispatch_Protocol = Sporadic;
		attribute :>> Period = 1000 [ms];
		
		//@Properties {
		//	Dispatch_Protocol = Sporadic;
		//	Period = 1000;
		//}
	}

	part def Fan :> Thread {
		// features
		in port fanCmd : EventDataPort { in :> type : FanCmd; }
		out port fanAck : EventDataPort { out :> type : FanAck; }
		
		attribute :>> Dispatch_Protocol = Sporadic;
		attribute :>> Period = 1000 [ms];
		
		//@Properties {
		//	Dispatch_Protocol = Sporadic;
		//	Period = 1000;
		//}
	}

	part def OperatorInterface :> Thread {
		// features
		in port currentTemp : DataPort { in :> type : Temperature; }
		out port setPoint : EventDataPort { out :> type : SetPoint; }
	
		attribute :>> Dispatch_Protocol = Periodic;
	    attribute :>> Period = 1000 [ms];
	    
		//@Properties {
		//	Dispatch_Protocol = Periodic;
		//	Period = 1000;
		//}
	}

	// Data Types
	part def Temperature :> Data {
		attribute degrees : Base_Types::Float_32;
		attribute unit : TempUnit;
	}
	
	part def SetPoint :> Data {
		part low : Temperature;
		part high : Temperature;
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