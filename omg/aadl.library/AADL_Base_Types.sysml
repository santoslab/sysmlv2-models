standard library package AADL_Base_Types {

  import AADL::*;
  import SI::*;

  // TODO: convert Data_Model::Data_Representation properties

  part def Boolean :> Data;

  part def Integer :> Data;

  part def Integer_8 :> Integer;
  part def Integer_16 :> Integer;
  part def Integer_32 :> Integer;
  part def Integer_64 :> Integer;

  part def Unsigned_8 :> Integer;
  part def Unsigned_16 :> Integer;
  part def Unsigned_32 :> Integer;
  part def Unsigned_64 :> Integer;

  part def Float :> Data;

  part def Float_32 :> Float;
  part def Float_64 :> Float;

  part def Character :> Data;

  part def String :> Data;

}