// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait Fan_Api {
  def id: Art.BridgeId
  def fanCmd_Id : Art.PortId
  def fanAck_Id : Art.PortId

  def put_fanAck(value : TempControlAadl.FanAck) : Unit = {
    Art.putValue(fanAck_Id, TempControlAadl.FanAck_Payload(value))
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
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId) extends Fan_Api

@datatype class Fan_Operational_Api (
  val id: Art.BridgeId,
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId) extends Fan_Api {

  def get_fanCmd() : Option[TempControlAadl.FanCmd] = {
    val value : Option[TempControlAadl.FanCmd] = Art.getValue(fanCmd_Id) match {
      case Some(TempControlAadl.FanCmd_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fanCmd.  Expecting 'TempControlAadl.FanCmd_Payload' but received ${v}")
        None[TempControlAadl.FanCmd]()
      case _ => None[TempControlAadl.FanCmd]()
    }
    return value
  }
}
