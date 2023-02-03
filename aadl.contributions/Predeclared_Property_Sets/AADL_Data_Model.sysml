package AADL_Data_Model {
	
	attribute def Range {
		attribute low: ScalarValues::Integer;
		attribute high: ScalarValues::Integer;	
	}
	
	metadata def Data_Model {
		attribute IEEE754_Precision : Supported_Precisions;
		attribute Data_Representation : Supported_Data_Representations;
		attribute Number_Representation : Supported_Number_Representations;
		attribute Integer_Range : Range;
	}
	
	enum def Supported_Precisions {
		enum Simple;
		enum Double;
	}
	
	alias Simple for Supported_Precisions::Simple;
	alias Double for Supported_Precisions::Double;
	
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
	
	alias Signed for Supported_Number_Representations::Signed;
	alias Unsigned for Supported_Number_Representations::Unsigned;
}