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

  ports_currentTemp: Port[TempControlAadl.Temperature],
  ports_tempChanged: Port[art.Empty],
  ports_fanCmd: Port[TempControlAadl.FanCmd.Type],
  ports_fanAck: Port[TempControlAadl.FanAck.Type],
  ports_setPoint: Port[TempControlAadl.SetPoint]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(ports_currentTemp,
              ports_tempChanged,
              ports_fanCmd,
              ports_fanAck,
              ports_setPoint),

    dataIns = ISZ(ports_currentTemp),

    dataOuts = ISZ(),

    eventIns = ISZ(ports_tempChanged,
                   ports_fanAck,
                   ports_setPoint),

    eventOuts = ISZ(ports_fanCmd)
  )

  val initialization_api : TempControl_Initialization_Api = {
    val api = TempControl_Initialization_Api(
      id,
      ports_currentTemp.id,
      ports_tempChanged.id,
      ports_fanCmd.id,
      ports_fanAck.id,
      ports_setPoint.id
    )
    TempControl_tcp_tempControl_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : TempControl_Operational_Api = {
    val api = TempControl_Operational_Api(
      id,
      ports_currentTemp.id,
      ports_tempChanged.id,
      ports_fanCmd.id,
      ports_fanAck.id,
      ports_setPoint.id
    )
    TempControl_tcp_tempControl_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    TempControl_tcp_tempControl_Bridge.EntryPoints(
      id,

      ports_currentTemp.id,
      ports_tempChanged.id,
      ports_fanCmd.id,
      ports_fanAck.id,
      ports_setPoint.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object TempControl_tcp_tempControl_Bridge {

  var c_initialization_api: Option[TempControl_Initialization_Api] = None()
  var c_operational_api: Option[TempControl_Operational_Api] = None()

  @datatype class EntryPoints(
    TempControl_tcp_tempControl_BridgeId : Art.BridgeId,
    ports_currentTemp_Id : Art.PortId,
    ports_tempChanged_Id : Art.PortId,
    ports_fanCmd_Id : Art.PortId,
    ports_fanAck_Id : Art.PortId,
    ports_setPoint_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: TempControl_Initialization_Api,
    operational_api: TempControl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(ports_currentTemp_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(ports_tempChanged_Id,
                                              ports_fanAck_Id,
                                              ports_setPoint_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(ports_fanCmd_Id)

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
        if(portId == ports_tempChanged_Id) {
          // implement the following in 'component':  def handle_ports_tempChanged(api: TempControl_Operational_Api): Unit = {}
          component.handle_ports_tempChanged(operational_api)
        }
        else if(portId == ports_fanAck_Id){
          val Some(TempControlAadl.FanAck_Payload(value)) = Art.getValue(ports_fanAck_Id)

          // implement the following in 'component':  def handle_ports_fanAck(api: TempControl_Operational_Api, value: TempControlAadl.FanAck.Type): Unit = {}
          component.handle_ports_fanAck(operational_api, value)
        }
        else if(portId == ports_setPoint_Id){
          val Some(TempControlAadl.SetPoint_Payload(value)) = Art.getValue(ports_setPoint_Id)

          // implement the following in 'component':  def handle_ports_setPoint(api: TempControl_Operational_Api, value: TempControlAadl.SetPoint): Unit = {}
          component.handle_ports_setPoint(operational_api, value)
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
        if(portId == ports_tempChanged_Id) {
          // implement the following in 'component':  def handle_ports_tempChanged(api: TempControl_Operational_Api): Unit = {}
          component.handle_ports_tempChanged(operational_api)
        }
        else if(portId == ports_fanAck_Id){
          val Some(TempControlAadl.FanAck_Payload(value)) = Art.getValue(ports_fanAck_Id)

          // implement the following in 'component':  def handle_ports_fanAck(api: TempControl_Operational_Api, value: TempControlAadl.FanAck.Type): Unit = {}
          component.handle_ports_fanAck(operational_api, value)
        }
        else if(portId == ports_setPoint_Id){
          val Some(TempControlAadl.SetPoint_Payload(value)) = Art.getValue(ports_setPoint_Id)

          // implement the following in 'component':  def handle_ports_setPoint(api: TempControl_Operational_Api, value: TempControlAadl.SetPoint): Unit = {}
          component.handle_ports_setPoint(operational_api, value)
        }
      }

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}