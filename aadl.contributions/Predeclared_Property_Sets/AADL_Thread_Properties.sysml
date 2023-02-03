package AADL_Thread_Properties {
	
	// Defines the type for Dispatch_Protocol as an enum with two potential values
	enum def Supported_Dispatch_Protocols {
		enum Sporadic;
		enum Periodic;
    }
    
	metadata def Thread_Properties {
		attribute Dispatch_Protocol : Supported_Dispatch_Protocols;
	}
}