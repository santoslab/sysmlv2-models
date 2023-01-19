// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate TempControlAadl::SetPoint

object SetPoint {
  def example(): TempControlAadl.SetPoint = {
    return SetPoint(
      low = Temperature.example(),
      high = Temperature.example())
  }
}

@datatype class SetPoint(val low: Temperature,
                         val high: Temperature)

object SetPoint_Payload {
  def example(): SetPoint_Payload = {
    return SetPoint_Payload(TempControlAadl.SetPoint.example())
  }
}

@datatype class SetPoint_Payload(value: TempControlAadl.SetPoint) extends art.DataContent
