// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file was auto-generated.  Do not edit

object Temperature {
  def example(): TempControlAadl.Temperature = {
    return TempControlAadl.Temperature(
      degrees = Base_Types.Float_32_example(),
      unit = TempControlAadl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class Temperature(
  val degrees: F32,
  val unit: TempControlAadl.TempUnit.Type) {
}

object Temperature_Payload {
  def example(): Temperature_Payload = {
    return Temperature_Payload(TempControlAadl.Temperature.example())
  }
}

@datatype class Temperature_Payload(value: TempControlAadl.Temperature) extends art.DataContent
