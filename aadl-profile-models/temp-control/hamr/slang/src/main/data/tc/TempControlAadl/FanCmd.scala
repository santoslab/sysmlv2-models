// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit

// This is a type skeleton as HAMR doesn't know how to translate TempControlAadl::FanCmd

object FanCmd {
  def example(): TempControlAadl.FanCmd = {
    return TempControlAadl.FanCmd()
  }
}

@datatype class FanCmd()

object FanCmd_Payload {
  def example(): FanCmd_Payload = {
    return FanCmd_Payload(TempControlAadl.FanCmd.example())
  }
}

@datatype class FanCmd_Payload(value: TempControlAadl.FanCmd) extends art.DataContent
