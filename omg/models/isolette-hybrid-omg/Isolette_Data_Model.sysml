// Isolette_Data_Model.sysml

package Isolette_Data_Model {
	
	import AADL::*;
	import AADL_Base_Types::*;
	import ScalarValues::*;
	
	part def PhysicalTemp :> Data {
		part degrees : Float_32;
	}
	
	part def TempWstatus :> Data {
		part degrees : Float_32;
		attribute status : ValueStatus;
	}
	
	part def Temp :> Data {
		part temp : Float_32;
	}
	
	enum def On_Off {
		enum Onn;
		enum Off;
	}
		
	part def Failure_Flag :> Data {
		flag : Boolean;
	}
	
	enum def ValueStatus {
		enum Valid;
		enum Invalid;
	}
	
	// Regulator and Monitor Status
	enum def Status {
		enum Init_Status;
		enum On_Status;
		enum Failed_Status;
	}
	
	// Regulator Mode
	enum def Regulator_Mode {
		enum Init_Regulator_Mode;
		enum Normal_Regulator_Mode;
		enum Failed_Regulator_Mode;
	}
	
	// Monitor Mode
	enum def Monitor_Mode {
		enum Init_Monitor_Mode;
		enum Normal_Monitor_Mode;
		enum Failed_Monitor_Mode;
	}
	
	//Table A-3 Thermostat Monitored Variables for Temperature  Sensor

	// current temperature : TempWstatus
	
	//Table A-4 Thermostat Controlled Variables for Heat Source
	
	// heat control : On_Off
	
	//Table A-5
	
	// lower desired temperature : TempWstatus
	// upper desired temperature : TempWstatus
	// lower alarm temperature : TempWstatus
	// upper alarm temperature : TempWstatus
	
	//range of Monitored Temperature  
	// data Measured_Temperature_Range
	// properties
	// Data_Model::Base_Type => (classifier(BLESS_Types::Fixed_Point));  
	//  Data_Model::Real_Range => 68.0 .. 105.0;
	//  Data_Model::Measurement_Unit => "Fahrenheit";
	//  BLESS::Typed => "real 68.0 .. 105.0 units Fahrenheit";
	//  end Measured_Temperature_Range;  
	
	//Valid/Invalid enumerated type
	
	
	//Current Temperature "t" is temp, "status" is valid/invalid flag 
	// data Current_Temperature 
	//  properties
	//  Data_Model::Data_Representation => Struct;
	//  Data_Model::Element_Names => ("t","status");
	//  Data_Model::Base_Type => (classifier (Measured_Temperature_Range), 
	//  	classifier (Valid_Flag));
	//  BLESS::Typed => "record (t:measured_temperature_range; status:valid_flag;)";
	// end Current_Temperature; 
	
	
	//Table A-4. Thermostat Controlled Variables for Heat Source
	
	//heat control and alarm value
	
	
	//Table A-5
}