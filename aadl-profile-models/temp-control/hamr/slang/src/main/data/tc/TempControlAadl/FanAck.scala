// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file was auto-generated.  Do not edit

@enum object FanAck {
  "Ok"
  "Error"
}

object FanAck_Payload {
  def example(): FanAck_Payload = {
    return FanAck_Payload(TempControlAadl.FanAck.byOrdinal(0).get)
  }
}

@datatype class FanAck_Payload(value: TempControlAadl.FanAck.Type) extends art.DataContent
