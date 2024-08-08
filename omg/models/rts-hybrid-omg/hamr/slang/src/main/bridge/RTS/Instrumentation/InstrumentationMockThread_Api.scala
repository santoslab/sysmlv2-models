// #Sireum

package RTS.Instrumentation

import org.sireum._
import art._
import RTS._

@sig trait InstrumentationMockThread_Api {
  def id: Art.BridgeId
  def ports_unit1_temperatureLogic_channel1_Id : Art.PortId
  def ports_unit1_temperatureLogic_channel2_Id : Art.PortId
  def ports_unit1_temperatureLogic_channel3_Id : Art.PortId
  def ports_unit1_temperatureLogic_channel4_Id : Art.PortId
  def ports_unit1_pressureLogic_channel1_Id : Art.PortId
  def ports_unit1_pressureLogic_channel2_Id : Art.PortId
  def ports_unit1_pressureLogic_channel3_Id : Art.PortId
  def ports_unit1_pressureLogic_channel4_Id : Art.PortId
  def ports_unit1_saturationLogic_channel1_Id : Art.PortId
  def ports_unit1_saturationLogic_channel2_Id : Art.PortId
  def ports_unit1_saturationLogic_channel3_Id : Art.PortId
  def ports_unit1_saturationLogic_channel4_Id : Art.PortId
  def ports_unit2_temperatureLogic_channel1_Id : Art.PortId
  def ports_unit2_temperatureLogic_channel2_Id : Art.PortId
  def ports_unit2_temperatureLogic_channel3_Id : Art.PortId
  def ports_unit2_temperatureLogic_channel4_Id : Art.PortId
  def ports_unit2_pressureLogic_channel1_Id : Art.PortId
  def ports_unit2_pressureLogic_channel2_Id : Art.PortId
  def ports_unit2_pressureLogic_channel3_Id : Art.PortId
  def ports_unit2_pressureLogic_channel4_Id : Art.PortId
  def ports_unit2_saturationLogic_channel1_Id : Art.PortId
  def ports_unit2_saturationLogic_channel2_Id : Art.PortId
  def ports_unit2_saturationLogic_channel3_Id : Art.PortId
  def ports_unit2_saturationLogic_channel4_Id : Art.PortId

  def put_ports_unit1_temperatureLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_temperatureLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_temperatureLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_temperatureLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_temperatureLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_temperatureLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_temperatureLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_temperatureLogic_channel4_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_pressureLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_pressureLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_pressureLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_pressureLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_pressureLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_pressureLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_pressureLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_pressureLogic_channel4_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_saturationLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_saturationLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_saturationLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_saturationLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_saturationLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_saturationLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit1_saturationLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit1_saturationLogic_channel4_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_temperatureLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_temperatureLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_temperatureLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_temperatureLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_temperatureLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_temperatureLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_temperatureLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_temperatureLogic_channel4_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_pressureLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_pressureLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_pressureLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_pressureLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_pressureLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_pressureLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_pressureLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_pressureLogic_channel4_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_saturationLogic_channel1(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_saturationLogic_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_saturationLogic_channel2(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_saturationLogic_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_saturationLogic_channel3(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_saturationLogic_channel3_Id, Base_Types.Boolean_Payload(value))
  }

  def put_ports_unit2_saturationLogic_channel4(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_unit2_saturationLogic_channel4_Id, Base_Types.Boolean_Payload(value))
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

@datatype class InstrumentationMockThread_Initialization_Api (
  val id: Art.BridgeId,
  val ports_unit1_temperatureLogic_channel1_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel2_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel3_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel4_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel1_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel2_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel3_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel4_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel1_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel2_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel3_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel4_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel1_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel2_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel3_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel4_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel1_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel2_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel3_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel4_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel1_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel2_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel3_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel4_Id : Art.PortId) extends InstrumentationMockThread_Api

@datatype class InstrumentationMockThread_Operational_Api (
  val id: Art.BridgeId,
  val ports_unit1_temperatureLogic_channel1_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel2_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel3_Id : Art.PortId,
  val ports_unit1_temperatureLogic_channel4_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel1_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel2_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel3_Id : Art.PortId,
  val ports_unit1_pressureLogic_channel4_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel1_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel2_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel3_Id : Art.PortId,
  val ports_unit1_saturationLogic_channel4_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel1_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel2_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel3_Id : Art.PortId,
  val ports_unit2_temperatureLogic_channel4_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel1_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel2_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel3_Id : Art.PortId,
  val ports_unit2_pressureLogic_channel4_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel1_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel2_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel3_Id : Art.PortId,
  val ports_unit2_saturationLogic_channel4_Id : Art.PortId) extends InstrumentationMockThread_Api {

}
