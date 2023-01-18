// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait TempControl_Api {
  def id: Art.BridgeId
  def currentTemp_Id : Art.PortId
  def tempChanged_Id : Art.PortId
  def fanCmd_Id : Art.PortId
  def fanAck_Id : Art.PortId
  def setPoint_Id : Art.PortId

  def put_fanCmd(value : TempControlAadl.FanCmd) : Unit = {
    Art.putValue(fanCmd_Id, TempControlAadl.FanCmd_Payload(value))
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
  val currentTemp_Id : Art.PortId,
  val tempChanged_Id : Art.PortId,
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId,
  val setPoint_Id : Art.PortId) extends TempControl_Api

@datatype class TempControl_Operational_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val tempChanged_Id : Art.PortId,
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId,
  val setPoint_Id : Art.PortId) extends TempControl_Api {

  def get_currentTemp() : Option[TempControlAadl.Temperature] = {
    val value : Option[TempControlAadl.Temperature] = Art.getValue(currentTemp_Id) match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port currentTemp.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
        None[TempControlAadl.Temperature]()
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }

  def get_tempChanged() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(tempChanged_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port tempChanged.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def get_fanAck() : Option[TempControlAadl.FanAck] = {
    val value : Option[TempControlAadl.FanAck] = Art.getValue(fanAck_Id) match {
      case Some(TempControlAadl.FanAck_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fanAck.  Expecting 'TempControlAadl.FanAck_Payload' but received ${v}")
        None[TempControlAadl.FanAck]()
      case _ => None[TempControlAadl.FanAck]()
    }
    return value
  }

  def get_setPoint() : Option[TempControlAadl.Temperature] = {
    val value : Option[TempControlAadl.Temperature] = Art.getValue(setPoint_Id) match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port setPoint.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
        None[TempControlAadl.Temperature]()
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }
}
