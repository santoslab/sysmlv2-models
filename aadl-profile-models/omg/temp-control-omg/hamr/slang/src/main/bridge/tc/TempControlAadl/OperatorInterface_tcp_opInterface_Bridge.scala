// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._
import tc.TempControlAadl.{OperatorInterface_tcp_opInterface => component}

// This file was auto-generated.  Do not edit

@datatype class OperatorInterface_tcp_opInterface_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_currentTemp: Port[TempControlAadl.Temperature],
  ports_setPoint: Port[TempControlAadl.SetPoint]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    dataIns = ISZ[art.UPort](ports_currentTemp),

    dataOuts = ISZ[art.UPort](),

    eventIns = ISZ[art.UPort](),

    eventOuts = ISZ[art.UPort](ports_setPoint)
  )

  val initialization_api : OperatorInterface_Initialization_Api = {
    val api = OperatorInterface_Initialization_Api(
      id,
      ports_currentTemp.id,
      ports_setPoint.id
    )
    OperatorInterface_tcp_opInterface_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : OperatorInterface_Operational_Api = {
    val api = OperatorInterface_Operational_Api(
      id,
      ports_currentTemp.id,
      ports_setPoint.id
    )
    OperatorInterface_tcp_opInterface_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    OperatorInterface_tcp_opInterface_Bridge.EntryPoints(
      id,

      ports_currentTemp.id,
      ports_setPoint.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object OperatorInterface_tcp_opInterface_Bridge {

  var c_initialization_api: Option[OperatorInterface_Initialization_Api] = None()
  var c_operational_api: Option[OperatorInterface_Operational_Api] = None()

  @datatype class EntryPoints(
    OperatorInterface_tcp_opInterface_BridgeId : Art.BridgeId,
    ports_currentTemp_Id : Art.PortId,
    ports_setPoint_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: OperatorInterface_Initialization_Api,
    operational_api: OperatorInterface_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = IS(ports_currentTemp_Id)

    val eventInPortIds: ISZ[Art.PortId] = IS()

    val dataOutPortIds: ISZ[Art.PortId] = IS()

    val eventOutPortIds: ISZ[Art.PortId] = IS(ports_setPoint_Id)

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: OperatorInterface_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: OperatorInterface_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: OperatorInterface_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: OperatorInterface_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: OperatorInterface_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: OperatorInterface_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: OperatorInterface_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: OperatorInterface_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}