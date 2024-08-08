// #Sireum

package RTS.Actuation

import org.sireum._
import art._
import RTS._

@sig trait Actuator_Api {
  def id: Art.BridgeId
  def ports_input_Id : Art.PortId
  def ports_manualActuatorInput_Id : Art.PortId
  def ports_output_Id : Art.PortId

  def put_ports_output(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_output_Id, Base_Types.Boolean_Payload(value))
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

@datatype class Actuator_Initialization_Api (
  val id: Art.BridgeId,
  val ports_input_Id : Art.PortId,
  val ports_manualActuatorInput_Id : Art.PortId,
  val ports_output_Id : Art.PortId) extends Actuator_Api

@datatype class Actuator_Operational_Api (
  val id: Art.BridgeId,
  val ports_input_Id : Art.PortId,
  val ports_manualActuatorInput_Id : Art.PortId,
  val ports_output_Id : Art.PortId) extends Actuator_Api {

  def get_ports_input() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_input_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_input.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def get_ports_manualActuatorInput() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_manualActuatorInput_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_manualActuatorInput.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }
}
