// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate TempControlAadl::Temperature

object Temperature {
  def example(): TempControlAadl.Temperature = {
    return TempControlAadl.Temperature(
      degrees = Base_Types.Float_32_example(),
      unit = TempUnit.byOrdinal(0).get
    )
  }
}

@datatype class Temperature(val degrees: F32,
                            val unit: TempUnit.Type)

object Temperature_Payload {
  def example(): Temperature_Payload = {
    return Temperature_Payload(TempControlAadl.Temperature.example())
  }
}

@datatype class Temperature_Payload(value: TempControlAadl.Temperature) extends art.DataContent
