// #Sireum

package tc.TempControlAadl

import org.sireum._
import art._
import tc._
import tc.TempControlAadl.{TempControl_tcp_tempControl => component}

// This file was auto-generated.  Do not edit

@datatype class TempControl_tcp_tempControl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  currentTemp: Port[TempControlAadl.Temperature],
  tempChanged: Port[art.Empty],
  fanCmd: Port[TempControlAadl.FanCmd],
  fanAck: Port[TempControlAadl.FanAck],
  setPoint: Port[TempControlAadl.Temperature]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(currentTemp,
              tempChanged,
              fanCmd,
              fanAck,
              setPoint),

    dataIns = ISZ(currentTemp),

    dataOuts = ISZ(),

    eventIns = ISZ(tempChanged,
                   fanAck,
                   setPoint),

    eventOuts = ISZ(fanCmd)
  )

  val initialization_api : TempControl_Initialization_Api = {
    val api = TempControl_Initialization_Api(
      id,
      currentTemp.id,
      tempChanged.id,
      fanCmd.id,
      fanAck.id,
      setPoint.id
    )
    TempControl_tcp_tempControl_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : TempControl_Operational_Api = {
    val api = TempControl_Operational_Api(
      id,
      currentTemp.id,
      tempChanged.id,
      fanCmd.id,
      fanAck.id,
      setPoint.id
    )
    TempControl_tcp_tempControl_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    TempControl_tcp_tempControl_Bridge.EntryPoints(
      id,

      currentTemp.id,
      tempChanged.id,
      fanCmd.id,
      fanAck.id,
      setPoint.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object TempControl_tcp_tempControl_Bridge {

  var c_initialization_api: Option[TempControl_Initialization_Api] = None()
  var c_operational_api: Option[TempControl_Operational_Api] = None()

  @datatype class EntryPoints(
    TempControl_tcp_tempControl_BridgeId : Art.BridgeId,
    currentTemp_Id : Art.PortId,
    tempChanged_Id : Art.PortId,
    fanCmd_Id : Art.PortId,
    fanAck_Id : Art.PortId,
    setPoint_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: TempControl_Initialization_Api,
    operational_api: TempControl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(currentTemp_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(tempChanged_Id,
                                              fanAck_Id,
                                              setPoint_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(fanCmd_Id)

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: TempControl_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_tcp_tempControl_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == tempChanged_Id) {
          // implement the following in 'component':  def handle_tempChanged(api: TempControl_Operational_Api): Unit = {}
          component.handle_tempChanged(operational_api)
        }
        else if(portId == fanAck_Id){
          val Some(TempControlAadl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)

          // implement the following in 'component':  def handle_fanAck(api: TempControl_Operational_Api, value: TempControlAadl.FanAck): Unit = {}
          component.handle_fanAck(operational_api, value)
        }
        else if(portId == setPoint_Id){
          val Some(TempControlAadl.Temperature_Payload(value)) = Art.getValue(setPoint_Id)

          // implement the following in 'component':  def handle_setPoint(api: TempControl_Operational_Api, value: TempControlAadl.Temperature): Unit = {}
          component.handle_setPoint(operational_api, value)
        }
      }

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: TempControl_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: TempControl_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: TempControl_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: TempControl_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: TempControl_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_tcp_tempControl_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == tempChanged_Id) {
          // implement the following in 'component':  def handle_tempChanged(api: TempControl_Operational_Api): Unit = {}
          component.handle_tempChanged(operational_api)
        }
        else if(portId == fanAck_Id){
          val Some(TempControlAadl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)

          // implement the following in 'component':  def handle_fanAck(api: TempControl_Operational_Api, value: TempControlAadl.FanAck): Unit = {}
          component.handle_fanAck(operational_api, value)
        }
        else if(portId == setPoint_Id){
          val Some(TempControlAadl.Temperature_Payload(value)) = Art.getValue(setPoint_Id)

          // implement the following in 'component':  def handle_setPoint(api: TempControl_Operational_Api, value: TempControlAadl.Temperature): Unit = {}
          component.handle_setPoint(operational_api, value)
        }
      }

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}