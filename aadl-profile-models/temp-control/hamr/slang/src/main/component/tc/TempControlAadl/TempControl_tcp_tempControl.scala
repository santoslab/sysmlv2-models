// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object TempControl_tcp_tempControl {

  def initialise(api: TempControl_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.put_fanCmd(TempControlAadl.FanCmd.example())
  }

  def handle_tempChanged(api: TempControl_Operational_Api): Unit = {
    api.logInfo("example handle_tempChanged implementation")
    api.logInfo("received tempChanged event")
    // example api usage

    val apiUsage_currentTemp: Option[TempControlAadl.Temperature] = api.get_currentTemp()
    api.logInfo(s"Received on currentTemp: ${apiUsage_currentTemp}")
    val apiUsage_tempChanged: Option[art.Empty] = api.get_tempChanged()
    api.logInfo(s"Received on tempChanged: ${apiUsage_tempChanged}")
    val apiUsage_fanAck: Option[TempControlAadl.FanAck] = api.get_fanAck()
    api.logInfo(s"Received on fanAck: ${apiUsage_fanAck}")
    val apiUsage_setPoint: Option[TempControlAadl.Temperature] = api.get_setPoint()
    api.logInfo(s"Received on setPoint: ${apiUsage_setPoint}")
  }

  def handle_fanAck(api: TempControl_Operational_Api, value : TempControlAadl.FanAck): Unit = {
    api.logInfo("example handle_fanAck implementation")
    api.logInfo(s"received ${value}")
  }

  def handle_setPoint(api: TempControl_Operational_Api, value : TempControlAadl.Temperature): Unit = {
    api.logInfo("example handle_setPoint implementation")
    api.logInfo(s"received ${value}")
  }

  def activate(api: TempControl_Operational_Api): Unit = { }

  def deactivate(api: TempControl_Operational_Api): Unit = { }

  def finalise(api: TempControl_Operational_Api): Unit = { }

  def recover(api: TempControl_Operational_Api): Unit = { }
}
