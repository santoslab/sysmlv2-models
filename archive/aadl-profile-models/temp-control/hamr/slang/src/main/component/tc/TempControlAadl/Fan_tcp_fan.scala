// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object Fan_tcp_fan {

  def initialise(api: Fan_Initialization_Api): Unit = {

  }

  def handle_ports_fanCmd(api: Fan_Operational_Api, value : TempControlAadl.FanCmd.Type): Unit = {
    // example api usage
    api.logInfo(s"received fanCmd $value")

    val ack = FanNative.fanCmdActuate(value)

    api.put_ports_fanAck(ack)

    api.logInfo(s"Actuation result: ${ack}")
  }

  def activate(api: Fan_Operational_Api): Unit = { }

  def deactivate(api: Fan_Operational_Api): Unit = { }

  def finalise(api: Fan_Operational_Api): Unit = { }

  def recover(api: Fan_Operational_Api): Unit = { }
}

@ext object FanNative {
  def fanCmdActuate(cmd: FanCmd.Type): FanAck.Type = $
}