// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate TempControlAadl::FanAck

object FanAck {
  def example(): TempControlAadl.FanAck = {
    return TempControlAadl.FanAck()
  }
}

@datatype class FanAck()

object FanAck_Payload {
  def example(): FanAck_Payload = {
    return FanAck_Payload(TempControlAadl.FanAck.example())
  }
}

@datatype class FanAck_Payload(value: TempControlAadl.FanAck) extends art.DataContent
