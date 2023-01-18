// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object Fan_tcp_fan {

  def initialise(api: Fan_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.put_fanAck(TempControlAadl.FanAck.example())
  }

  def handle_fanCmd(api: Fan_Operational_Api, value : TempControlAadl.FanCmd): Unit = {
    api.logInfo("example handle_fanCmd implementation")
    api.logInfo(s"received ${value}")
    // example api usage

    val apiUsage_fanCmd: Option[TempControlAadl.FanCmd] = api.get_fanCmd()
    api.logInfo(s"Received on fanCmd: ${apiUsage_fanCmd}")
  }

  def activate(api: Fan_Operational_Api): Unit = { }

  def deactivate(api: Fan_Operational_Api): Unit = { }

  def finalise(api: Fan_Operational_Api): Unit = { }

  def recover(api: Fan_Operational_Api): Unit = { }
}
