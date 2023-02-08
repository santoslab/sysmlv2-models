// #Sireum

package RTS.EventControl

import org.sireum._
import art._
import RTS._
import RTS.EventControl.{EventControlMockThread_eventControlMock_eventControlMockThread => component}

// This file was auto-generated.  Do not edit

@datatype class EventControlMockThread_eventControlMock_eventControlMockThread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_manualActuatorInput1: Port[Base_Types.Boolean],
  ports_manualActuatorInput2: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(ports_manualActuatorInput1,
              ports_manualActuatorInput2),

    dataIns = ISZ(),

    dataOuts = ISZ(ports_manualActuatorInput1,
                   ports_manualActuatorInput2),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : EventControlMockThread_Initialization_Api = {
    val api = EventControlMockThread_Initialization_Api(
      id,
      ports_manualActuatorInput1.id,
      ports_manualActuatorInput2.id
    )
    EventControlMockThread_eventControlMock_eventControlMockThread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : EventControlMockThread_Operational_Api = {
    val api = EventControlMockThread_Operational_Api(
      id,
      ports_manualActuatorInput1.id,
      ports_manualActuatorInput2.id
    )
    EventControlMockThread_eventControlMock_eventControlMockThread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    EventControlMockThread_eventControlMock_eventControlMockThread_Bridge.EntryPoints(
      id,

      ports_manualActuatorInput1.id,
      ports_manualActuatorInput2.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object EventControlMockThread_eventControlMock_eventControlMockThread_Bridge {

  var c_initialization_api: Option[EventControlMockThread_Initialization_Api] = None()
  var c_operational_api: Option[EventControlMockThread_Operational_Api] = None()

  @datatype class EntryPoints(
    EventControlMockThread_eventControlMock_eventControlMockThread_BridgeId : Art.BridgeId,
    ports_manualActuatorInput1_Id : Art.PortId,
    ports_manualActuatorInput2_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: EventControlMockThread_Initialization_Api,
    operational_api: EventControlMockThread_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(ports_manualActuatorInput1_Id,
                                              ports_manualActuatorInput2_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: EventControlMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: EventControlMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: EventControlMockThread_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: EventControlMockThread_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: EventControlMockThread_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: EventControlMockThread_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: EventControlMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: EventControlMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}