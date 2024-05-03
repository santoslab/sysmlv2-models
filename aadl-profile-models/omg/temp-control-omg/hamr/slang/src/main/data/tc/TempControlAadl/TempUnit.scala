// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file was auto-generated.  Do not edit

@enum object TempUnit {
  "Fahrenheit"
  "Celsius"
  "Kelvin"
}

object TempUnit_Payload {
  def example(): TempUnit_Payload = {
    return TempUnit_Payload(TempControlAadl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class TempUnit_Payload(value: TempControlAadl.TempUnit.Type) extends art.DataContent
