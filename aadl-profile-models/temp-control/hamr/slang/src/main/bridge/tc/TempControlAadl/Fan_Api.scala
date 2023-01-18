// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait Fan_Api {
  def id: Art.BridgeId
  def ports_fanCmd_Id : Art.PortId
  def ports_fanAck_Id : Art.PortId

  def put_ports_fanAck(value : TempControlAadl.FanAck.Type) : Unit = {
    Art.putValue(ports_fanAck_Id, TempControlAadl.FanAck_Payload(value))
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class Fan_Initialization_Api (
  val id: Art.BridgeId,
  val ports_fanCmd_Id : Art.PortId,
  val ports_fanAck_Id : Art.PortId) extends Fan_Api

@datatype class Fan_Operational_Api (
  val id: Art.BridgeId,
  val ports_fanCmd_Id : Art.PortId,
  val ports_fanAck_Id : Art.PortId) extends Fan_Api {

  def get_ports_fanCmd() : Option[TempControlAadl.FanCmd.Type] = {
    val value : Option[TempControlAadl.FanCmd.Type] = Art.getValue(ports_fanCmd_Id) match {
      case Some(TempControlAadl.FanCmd_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_fanCmd.  Expecting 'TempControlAadl.FanCmd_Payload' but received ${v}")
        None[TempControlAadl.FanCmd.Type]()
      case _ => None[TempControlAadl.FanCmd.Type]()
    }
    return value
  }
}
