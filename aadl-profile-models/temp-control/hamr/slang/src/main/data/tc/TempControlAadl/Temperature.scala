// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate TempControlAadl::Temperature

object Temperature {
  def example(): TempControlAadl.Temperature = {
    return TempControlAadl.Temperature()
  }
}

@datatype class Temperature()

object Temperature_Payload {
  def example(): Temperature_Payload = {
    return Temperature_Payload(TempControlAadl.Temperature.example())
  }
}

@datatype class Temperature_Payload(value: TempControlAadl.Temperature) extends art.DataContent
