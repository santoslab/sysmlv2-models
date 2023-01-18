// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait OperatorInterface_Api {
  def id: Art.BridgeId
  def ports_currentTemp_Id : Art.PortId
  def ports_setPoint_Id : Art.PortId

  def put_ports_setPoint(value : TempControlAadl.Temperature) : Unit = {
    Art.putValue(ports_setPoint_Id, TempControlAadl.Temperature_Payload(value))
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

@datatype class OperatorInterface_Initialization_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_setPoint_Id : Art.PortId) extends OperatorInterface_Api

@datatype class OperatorInterface_Operational_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_setPoint_Id : Art.PortId) extends OperatorInterface_Api {

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
}
