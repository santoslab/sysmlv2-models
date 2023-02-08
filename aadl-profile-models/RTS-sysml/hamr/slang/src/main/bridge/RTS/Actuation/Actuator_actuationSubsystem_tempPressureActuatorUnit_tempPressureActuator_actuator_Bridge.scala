// #Sireum

package RTS.Actuation

import org.sireum._
import art._
import RTS._
import RTS.Actuation.{Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator => component}

// This file was auto-generated.  Do not edit

@datatype class Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_input: Port[Base_Types.Boolean],
  ports_manualActuatorInput: Port[Base_Types.Boolean],
  ports_output: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(ports_input,
              ports_manualActuatorInput,
              ports_output),

    dataIns = ISZ(ports_input,
                  ports_manualActuatorInput),

    dataOuts = ISZ(ports_output),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Actuator_Initialization_Api = {
    val api = Actuator_Initialization_Api(
      id,
      ports_input.id,
      ports_manualActuatorInput.id,
      ports_output.id
    )
    Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Actuator_Operational_Api = {
    val api = Actuator_Operational_Api(
      id,
      ports_input.id,
      ports_manualActuatorInput.id,
      ports_output.id
    )
    Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge.EntryPoints(
      id,

      ports_input.id,
      ports_manualActuatorInput.id,
      ports_output.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge {

  var c_initialization_api: Option[Actuator_Initialization_Api] = None()
  var c_operational_api: Option[Actuator_Operational_Api] = None()

  @datatype class EntryPoints(
    Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_BridgeId : Art.BridgeId,
    ports_input_Id : Art.PortId,
    ports_manualActuatorInput_Id : Art.PortId,
    ports_output_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: Actuator_Initialization_Api,
    operational_api: Actuator_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(ports_input_Id,
                                             ports_manualActuatorInput_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(ports_output_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: Actuator_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: Actuator_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: Actuator_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: Actuator_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: Actuator_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: Actuator_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: Actuator_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: Actuator_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}