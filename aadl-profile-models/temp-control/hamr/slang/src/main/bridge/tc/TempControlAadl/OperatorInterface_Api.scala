// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait OperatorInterface_Api {
  def id: Art.BridgeId
  def currentTemp_Id : Art.PortId
  def setPoint_Id : Art.PortId

  def put_setPoint(value : TempControlAadl.Temperature) : Unit = {
    Art.putValue(setPoint_Id, TempControlAadl.Temperature_Payload(value))
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
  val currentTemp_Id : Art.PortId,
  val setPoint_Id : Art.PortId) extends OperatorInterface_Api

@datatype class OperatorInterface_Operational_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val setPoint_Id : Art.PortId) extends OperatorInterface_Api {

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
}
