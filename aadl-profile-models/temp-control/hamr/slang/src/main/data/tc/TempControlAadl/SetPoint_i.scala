// #Sireum

package tc.TempControlAadl

import org.sireum._

// This file was auto-generated.  Do not edit

object SetPoint_i {
  def example(): SetPoint_i = {
    return SetPoint_i(
      low = Temperature.example(),
      high = Temperature.example())
  }
}

@datatype class SetPoint_i(
  val low: Temperature,
  val high: Temperature) {
}

object SetPoint_i_Payload {
  def example(): SetPoint_i_Payload = {
    return SetPoint_i_Payload(SetPoint_i.example())
  }
}

@datatype class SetPoint_i_Payload(value: SetPoint_i) extends art.DataContent
