package Base_Types {
	
	import AADLProperties::*;
	
	datatype Boolean :> ScalarValues::Boolean {
		@Data_Properties {
			Data_Representation = Supported_Data_Representations::Boolean;
		}
	}

    datatype Integer :> ScalarValues::Integer {
    	@Data_Properties {
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }

    datatype Integer_8 :> Integer {
    	@Data_Properties {
    		Data_Size = 8;
    		Number_Representation = Supported_Number_Representations::Signed;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Integer_16 :> Integer {
    	@Data_Properties {
    		Data_Size = 16;
    		Number_Representation = Supported_Number_Representations::Signed;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Integer_32 :> Integer {
    	@Data_Properties {
    		Data_Size = 32;
    		Number_Representation = Supported_Number_Representations::Signed;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Integer_64 :> Integer {
    	@Data_Properties {
    		Data_Size = 64;
    		Number_Representation = Supported_Number_Representations::Signed;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }

    datatype Unsigned_8 :> Integer {
    	@Data_Properties {
    		Data_Size = 8;
    		Number_Representation = Supported_Number_Representations::Unsigned;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Unsigned_16 :> Integer {
    	@Data_Properties {
    		Data_Size = 16;
    		Number_Representation = Supported_Number_Representations::Unsigned;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Unsigned_32 :> Integer {
    	@Data_Properties {
    		Data_Size = 32;
    		Number_Representation = Supported_Number_Representations::Unsigned;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }
    
    datatype Unsigned_64 :> Integer {
    	@Data_Properties {
    		Data_Size = 64;
    		Number_Representation = Supported_Number_Representations::Unsigned;
    		Data_Representation = Supported_Data_Representations::Integer;
    	}
    }

    datatype Float :> ScalarValues::Rational {
    	@Data_Properties {
    		Data_Representation = Supported_Data_Representations::Float;
    	}
    }
    
    datatype Float_32 :> Float {
    	@Data_Properties {
    		Data_Size = 32;
    		IEEE754_Precision = Supported_Precisions::Simple;
    		Data_Representation = Supported_Data_Representations::Float;
    	}
    }
    
    datatype Float_64 :> Float {
    	@Data_Properties {
    		Data_Size = 64;
    		IEEE754_Precision = Supported_Precisions::Simple;
    		Data_Representation = Supported_Data_Representations::Float;
    	}
    }
    
    datatype String :> ScalarValues::String {
    	@Data_Properties {
    		Data_Representation = Data_Representation::String;
    	}
    }
    
    datatype Character {
    	@Data_Properties {
    		Data_Representation = Data_Representation::Character;
    	}
    }
}