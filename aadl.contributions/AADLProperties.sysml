//Stores definitions of AADL properties
package AADLProperties {

	private import MeasurementReferences::*;
	import ISQ::*;
	import SIPrefixes::*;

	//attribute <ps> picoSecond : DurationUnit { :>> unitConversion: ConversionByPrefix { :>> prefix = pico; :>> referenceUnit = SI::s ; } }

	metadata def Thread_Properties {
		attribute Dispatch_Protocol : Supported_Dispatch_Protocols;
	}

	metadata def Timing_Properties {
		// Assumes milliseconds
		attribute Period : ScalarValues::Integer;
	}

	// Attach the "Properties" metadata to a part to assign AADL-like properties
	metadata def Properties :> Thread_Properties, Timing_Properties {}
	
	metadata def Data_Properties :> Memory_Properties, Data_Model {}
	
	metadata def Memory_Properties {
		// Currently assumes bits
		attribute Data_Size : ScalarValues::Integer;
	}
	
	metadata def Data_Model {
		attribute IEEE754_Precision : Supported_Precisions;
		attribute Data_Representation : Supported_Data_Representations;
		attribute Number_Representation : Supported_Number_Representations;
	}

	// Defines the type for Dispatch_Protocol as an enum with two potential values
	enum def Supported_Dispatch_Protocols {
		enum Sporadic;
		enum Periodic;
	}
	
	enum def Supported_Precisions {
		enum Simple;
		enum Double;
	}
	
	enum def Supported_Data_Representations {
		enum Boolean;
		enum Integer;
		enum Float;
		enum String;
		enum Character;
	}
	
	enum def Supported_Number_Representations {
		enum Signed;
		enum Unsigned;
	}

	// These aliases allow the enumerated values to be referenced more easily
	alias Sporadic for Supported_Dispatch_Protocols::Sporadic;
	alias Periodic for Supported_Dispatch_Protocols::Periodic;

}