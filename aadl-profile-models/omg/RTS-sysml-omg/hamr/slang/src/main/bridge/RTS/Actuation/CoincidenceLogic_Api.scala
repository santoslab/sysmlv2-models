// #Sireum

package RTS.Actuation

import org.sireum._
import art._
import RTS._

@sig trait CoincidenceLogic_Api {
  def id: Art.BridgeId
  def ports_channel1_Id : Art.PortId
  def ports_channel2_Id : Art.PortId
  def ports_channel3_Id : Art.PortId
  def ports_channel4_Id : Art.PortId
  def ports_actuate_Id : Art.PortId

  def put_ports_actuate(value : Base_Types.Boolean) : Unit = {
    Art.putValue(ports_actuate_Id, Base_Types.Boolean_Payload(value))
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

@datatype class CoincidenceLogic_Initialization_Api (
  val id: Art.BridgeId,
  val ports_channel1_Id : Art.PortId,
  val ports_channel2_Id : Art.PortId,
  val ports_channel3_Id : Art.PortId,
  val ports_channel4_Id : Art.PortId,
  val ports_actuate_Id : Art.PortId) extends CoincidenceLogic_Api

@datatype class CoincidenceLogic_Operational_Api (
  val id: Art.BridgeId,
  val ports_channel1_Id : Art.PortId,
  val ports_channel2_Id : Art.PortId,
  val ports_channel3_Id : Art.PortId,
  val ports_channel4_Id : Art.PortId,
  val ports_actuate_Id : Art.PortId) extends CoincidenceLogic_Api {

  def get_ports_channel1() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_channel1_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def get_ports_channel2() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_channel2_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def get_ports_channel3() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_channel3_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def get_ports_channel4() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(ports_channel4_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ports_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }
}
