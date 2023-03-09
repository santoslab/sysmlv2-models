// #Sireum

package RTS.Actuators

import org.sireum._
import art._
import RTS._
import RTS.Actuators.{ActuatorsMockThread_actuatorsMock_actuatorsMockThread => component}

// This file was auto-generated.  Do not edit

@datatype class ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_tempPressureActuate: Port[Base_Types.Boolean],
  ports_saturationActuate: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    dataIns = ISZ[art.UPort](ports_tempPressureActuate,
                             ports_saturationActuate),

    dataOuts = ISZ[art.UPort](),

    eventIns = ISZ[art.UPort](),

    eventOuts = ISZ[art.UPort]()
  )

  val initialization_api : ActuatorsMockThread_Initialization_Api = {
    val api = ActuatorsMockThread_Initialization_Api(
      id,
      ports_tempPressureActuate.id,
      ports_saturationActuate.id
    )
    ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : ActuatorsMockThread_Operational_Api = {
    val api = ActuatorsMockThread_Operational_Api(
      id,
      ports_tempPressureActuate.id,
      ports_saturationActuate.id
    )
    ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge.EntryPoints(
      id,

      ports_tempPressureActuate.id,
      ports_saturationActuate.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge {

  var c_initialization_api: Option[ActuatorsMockThread_Initialization_Api] = None()
  var c_operational_api: Option[ActuatorsMockThread_Operational_Api] = None()

  @datatype class EntryPoints(
    ActuatorsMockThread_actuatorsMock_actuatorsMockThread_BridgeId : Art.BridgeId,
    ports_tempPressureActuate_Id : Art.PortId,
    ports_saturationActuate_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: ActuatorsMockThread_Initialization_Api,
    operational_api: ActuatorsMockThread_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = IS(ports_tempPressureActuate_Id,
                                            ports_saturationActuate_Id)

    val eventInPortIds: ISZ[Art.PortId] = IS()

    val dataOutPortIds: ISZ[Art.PortId] = IS()

    val eventOutPortIds: ISZ[Art.PortId] = IS()

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: ActuatorsMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: ActuatorsMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: ActuatorsMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}