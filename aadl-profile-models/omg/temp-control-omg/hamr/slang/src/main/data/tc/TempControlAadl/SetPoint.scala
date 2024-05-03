// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file was auto-generated.  Do not edit

object SetPoint {
  def example(): TempControlAadl.SetPoint = {
    return TempControlAadl.SetPoint(
      low = TempControlAadl.Temperature.example(),
      high = TempControlAadl.Temperature.example())
  }
}

@datatype class SetPoint(
  val low: TempControlAadl.Temperature,
  val high: TempControlAadl.Temperature) {
}

object SetPoint_Payload {
  def example(): SetPoint_Payload = {
    return SetPoint_Payload(TempControlAadl.SetPoint.example())
  }
}

@datatype class SetPoint_Payload(value: TempControlAadl.SetPoint) extends art.DataContent
