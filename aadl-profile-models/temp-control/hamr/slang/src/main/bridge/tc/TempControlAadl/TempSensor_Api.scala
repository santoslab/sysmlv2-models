// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._

@sig trait TempSensor_Api {
  def id: Art.BridgeId
  def ports_currentTemp_Id : Art.PortId
  def ports_tempChanged_Id : Art.PortId

  def put_ports_currentTemp(value : TempControlAadl.Temperature) : Unit = {
    Art.putValue(ports_currentTemp_Id, TempControlAadl.Temperature_Payload(value))
  }

  def put_ports_tempChanged() : Unit = {
    Art.putValue(ports_tempChanged_Id, art.Empty())
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

@datatype class TempSensor_Initialization_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_tempChanged_Id : Art.PortId) extends TempSensor_Api

@datatype class TempSensor_Operational_Api (
  val id: Art.BridgeId,
  val ports_currentTemp_Id : Art.PortId,
  val ports_tempChanged_Id : Art.PortId) extends TempSensor_Api {

}
