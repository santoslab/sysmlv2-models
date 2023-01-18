// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait TempControl_Api {
  def id: Art.BridgeId
  def ports_currentTemp_Id : Art.PortId
  def ports_tempChanged_Id : Art.PortId
  def ports_fanCmd_Id : Art.PortId
  def ports_fanAck_Id : Art.PortId
  def ports_setPoint_Id : Art.PortId

  def put_ports_fanCmd(value : TempControlAadl.FanCmd.Type) : Unit = {
    Art.putValue(ports_fanCmd_Id, TempControlAadl.FanCmd_Payload(value))
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

@datatype class TempControl_Initialization_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_tempChanged_Id : Art.PortId,
  val ports_fanCmd_Id : Art.PortId,
  val ports_fanAck_Id : Art.PortId,
  val ports_setPoint_Id : Art.PortId) extends TempControl_Api

@datatype class TempControl_Operational_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_tempChanged_Id : Art.PortId,
  val ports_fanCmd_Id : Art.PortId,
  val ports_fanAck_Id : Art.PortId,
  val ports_setPoint_Id : Art.PortId) extends TempControl_Api {

  def get_ports_currentTemp() : Option[TempControlAadl.Temperature] = {
    val value : Option[TempControlAadl.Temperature] = Art.getValue(ports_currentTemp_Id) match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_currentTemp.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
        None[TempControlAadl.Temperature]()
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }

  def get_ports_tempChanged() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(ports_tempChanged_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_tempChanged.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def get_ports_fanAck() : Option[TempControlAadl.FanAck.Type] = {
    val value : Option[TempControlAadl.FanAck.Type] = Art.getValue(ports_fanAck_Id) match {
      case Some(TempControlAadl.FanAck_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_fanAck.  Expecting 'TempControlAadl.FanAck_Payload' but received ${v}")
        None[TempControlAadl.FanAck.Type]()
      case _ => None[TempControlAadl.FanAck.Type]()
    }
    return value
  }

  def get_ports_setPoint() : Option[TempControlAadl.Temperature] = {
    val value : Option[TempControlAadl.Temperature] = Art.getValue(ports_setPoint_Id) match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_setPoint.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
        None[TempControlAadl.Temperature]()
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }
}
