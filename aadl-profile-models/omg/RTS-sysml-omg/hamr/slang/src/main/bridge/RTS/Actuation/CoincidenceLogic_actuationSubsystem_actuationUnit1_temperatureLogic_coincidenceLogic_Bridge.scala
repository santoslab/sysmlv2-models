// #Sireum

package RTS.Actuation

import org.sireum._
import art._
import RTS._
import RTS.Actuation.{CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic => component}

// This file was auto-generated.  Do not edit

@datatype class CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_channel1: Port[Base_Types.Boolean],
  ports_channel2: Port[Base_Types.Boolean],
  ports_channel3: Port[Base_Types.Boolean],
  ports_channel4: Port[Base_Types.Boolean],
  ports_actuate: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    dataIns = ISZ[art.UPort](ports_channel1,
                             ports_channel2,
                             ports_channel3,
                             ports_channel4),

    dataOuts = ISZ[art.UPort](ports_actuate),

    eventIns = ISZ[art.UPort](),

    eventOuts = ISZ[art.UPort]()
  )

  val initialization_api : CoincidenceLogic_Initialization_Api = {
    val api = CoincidenceLogic_Initialization_Api(
      id,
      ports_channel1.id,
      ports_channel2.id,
      ports_channel3.id,
      ports_channel4.id,
      ports_actuate.id
    )
    CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : CoincidenceLogic_Operational_Api = {
    val api = CoincidenceLogic_Operational_Api(
      id,
      ports_channel1.id,
      ports_channel2.id,
      ports_channel3.id,
      ports_channel4.id,
      ports_actuate.id
    )
    CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge.EntryPoints(
      id,

      ports_channel1.id,
      ports_channel2.id,
      ports_channel3.id,
      ports_channel4.id,
      ports_actuate.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge {

  var c_initialization_api: Option[CoincidenceLogic_Initialization_Api] = None()
  var c_operational_api: Option[CoincidenceLogic_Operational_Api] = None()

  @datatype class EntryPoints(
    CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_BridgeId : Art.BridgeId,
    ports_channel1_Id : Art.PortId,
    ports_channel2_Id : Art.PortId,
    ports_channel3_Id : Art.PortId,
    ports_channel4_Id : Art.PortId,
    ports_actuate_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: CoincidenceLogic_Initialization_Api,
    operational_api: CoincidenceLogic_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = IS(ports_channel1_Id,
                                            ports_channel2_Id,
                                            ports_channel3_Id,
                                            ports_channel4_Id)

    val eventInPortIds: ISZ[Art.PortId] = IS()

    val dataOutPortIds: ISZ[Art.PortId] = IS(ports_actuate_Id)

    val eventOutPortIds: ISZ[Art.PortId] = IS()

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: CoincidenceLogic_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: CoincidenceLogic_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: CoincidenceLogic_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}