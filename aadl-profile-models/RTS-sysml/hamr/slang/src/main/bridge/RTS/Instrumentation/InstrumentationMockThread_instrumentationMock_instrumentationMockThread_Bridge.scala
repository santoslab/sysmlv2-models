// #Sireum

package RTS.Instrumentation

import org.sireum._
import art._
import RTS._
import RTS.Instrumentation.{InstrumentationMockThread_instrumentationMock_instrumentationMockThread => component}

// This file was auto-generated.  Do not edit

@datatype class InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  ports_unit1_temperatureLogic_channel1: Port[Base_Types.Boolean],
  ports_unit1_temperatureLogic_channel2: Port[Base_Types.Boolean],
  ports_unit1_temperatureLogic_channel3: Port[Base_Types.Boolean],
  ports_unit1_temperatureLogic_channel4: Port[Base_Types.Boolean],
  ports_unit1_pressureLogic_channel1: Port[Base_Types.Boolean],
  ports_unit1_pressureLogic_channel2: Port[Base_Types.Boolean],
  ports_unit1_pressureLogic_channel3: Port[Base_Types.Boolean],
  ports_unit1_pressureLogic_channel4: Port[Base_Types.Boolean],
  ports_unit1_saturationLogic_channel1: Port[Base_Types.Boolean],
  ports_unit1_saturationLogic_channel2: Port[Base_Types.Boolean],
  ports_unit1_saturationLogic_channel3: Port[Base_Types.Boolean],
  ports_unit1_saturationLogic_channel4: Port[Base_Types.Boolean],
  ports_unit2_temperatureLogic_channel1: Port[Base_Types.Boolean],
  ports_unit2_temperatureLogic_channel2: Port[Base_Types.Boolean],
  ports_unit2_temperatureLogic_channel3: Port[Base_Types.Boolean],
  ports_unit2_temperatureLogic_channel4: Port[Base_Types.Boolean],
  ports_unit2_pressureLogic_channel1: Port[Base_Types.Boolean],
  ports_unit2_pressureLogic_channel2: Port[Base_Types.Boolean],
  ports_unit2_pressureLogic_channel3: Port[Base_Types.Boolean],
  ports_unit2_pressureLogic_channel4: Port[Base_Types.Boolean],
  ports_unit2_saturationLogic_channel1: Port[Base_Types.Boolean],
  ports_unit2_saturationLogic_channel2: Port[Base_Types.Boolean],
  ports_unit2_saturationLogic_channel3: Port[Base_Types.Boolean],
  ports_unit2_saturationLogic_channel4: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(ports_unit1_temperatureLogic_channel1,
              ports_unit1_temperatureLogic_channel2,
              ports_unit1_temperatureLogic_channel3,
              ports_unit1_temperatureLogic_channel4,
              ports_unit1_pressureLogic_channel1,
              ports_unit1_pressureLogic_channel2,
              ports_unit1_pressureLogic_channel3,
              ports_unit1_pressureLogic_channel4,
              ports_unit1_saturationLogic_channel1,
              ports_unit1_saturationLogic_channel2,
              ports_unit1_saturationLogic_channel3,
              ports_unit1_saturationLogic_channel4,
              ports_unit2_temperatureLogic_channel1,
              ports_unit2_temperatureLogic_channel2,
              ports_unit2_temperatureLogic_channel3,
              ports_unit2_temperatureLogic_channel4,
              ports_unit2_pressureLogic_channel1,
              ports_unit2_pressureLogic_channel2,
              ports_unit2_pressureLogic_channel3,
              ports_unit2_pressureLogic_channel4,
              ports_unit2_saturationLogic_channel1,
              ports_unit2_saturationLogic_channel2,
              ports_unit2_saturationLogic_channel3,
              ports_unit2_saturationLogic_channel4),

    dataIns = ISZ(),

    dataOuts = ISZ(ports_unit1_temperatureLogic_channel1,
                   ports_unit1_temperatureLogic_channel2,
                   ports_unit1_temperatureLogic_channel3,
                   ports_unit1_temperatureLogic_channel4,
                   ports_unit1_pressureLogic_channel1,
                   ports_unit1_pressureLogic_channel2,
                   ports_unit1_pressureLogic_channel3,
                   ports_unit1_pressureLogic_channel4,
                   ports_unit1_saturationLogic_channel1,
                   ports_unit1_saturationLogic_channel2,
                   ports_unit1_saturationLogic_channel3,
                   ports_unit1_saturationLogic_channel4,
                   ports_unit2_temperatureLogic_channel1,
                   ports_unit2_temperatureLogic_channel2,
                   ports_unit2_temperatureLogic_channel3,
                   ports_unit2_temperatureLogic_channel4,
                   ports_unit2_pressureLogic_channel1,
                   ports_unit2_pressureLogic_channel2,
                   ports_unit2_pressureLogic_channel3,
                   ports_unit2_pressureLogic_channel4,
                   ports_unit2_saturationLogic_channel1,
                   ports_unit2_saturationLogic_channel2,
                   ports_unit2_saturationLogic_channel3,
                   ports_unit2_saturationLogic_channel4),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : InstrumentationMockThread_Initialization_Api = {
    val api = InstrumentationMockThread_Initialization_Api(
      id,
      ports_unit1_temperatureLogic_channel1.id,
      ports_unit1_temperatureLogic_channel2.id,
      ports_unit1_temperatureLogic_channel3.id,
      ports_unit1_temperatureLogic_channel4.id,
      ports_unit1_pressureLogic_channel1.id,
      ports_unit1_pressureLogic_channel2.id,
      ports_unit1_pressureLogic_channel3.id,
      ports_unit1_pressureLogic_channel4.id,
      ports_unit1_saturationLogic_channel1.id,
      ports_unit1_saturationLogic_channel2.id,
      ports_unit1_saturationLogic_channel3.id,
      ports_unit1_saturationLogic_channel4.id,
      ports_unit2_temperatureLogic_channel1.id,
      ports_unit2_temperatureLogic_channel2.id,
      ports_unit2_temperatureLogic_channel3.id,
      ports_unit2_temperatureLogic_channel4.id,
      ports_unit2_pressureLogic_channel1.id,
      ports_unit2_pressureLogic_channel2.id,
      ports_unit2_pressureLogic_channel3.id,
      ports_unit2_pressureLogic_channel4.id,
      ports_unit2_saturationLogic_channel1.id,
      ports_unit2_saturationLogic_channel2.id,
      ports_unit2_saturationLogic_channel3.id,
      ports_unit2_saturationLogic_channel4.id
    )
    InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : InstrumentationMockThread_Operational_Api = {
    val api = InstrumentationMockThread_Operational_Api(
      id,
      ports_unit1_temperatureLogic_channel1.id,
      ports_unit1_temperatureLogic_channel2.id,
      ports_unit1_temperatureLogic_channel3.id,
      ports_unit1_temperatureLogic_channel4.id,
      ports_unit1_pressureLogic_channel1.id,
      ports_unit1_pressureLogic_channel2.id,
      ports_unit1_pressureLogic_channel3.id,
      ports_unit1_pressureLogic_channel4.id,
      ports_unit1_saturationLogic_channel1.id,
      ports_unit1_saturationLogic_channel2.id,
      ports_unit1_saturationLogic_channel3.id,
      ports_unit1_saturationLogic_channel4.id,
      ports_unit2_temperatureLogic_channel1.id,
      ports_unit2_temperatureLogic_channel2.id,
      ports_unit2_temperatureLogic_channel3.id,
      ports_unit2_temperatureLogic_channel4.id,
      ports_unit2_pressureLogic_channel1.id,
      ports_unit2_pressureLogic_channel2.id,
      ports_unit2_pressureLogic_channel3.id,
      ports_unit2_pressureLogic_channel4.id,
      ports_unit2_saturationLogic_channel1.id,
      ports_unit2_saturationLogic_channel2.id,
      ports_unit2_saturationLogic_channel3.id,
      ports_unit2_saturationLogic_channel4.id
    )
    InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge.EntryPoints(
      id,

      ports_unit1_temperatureLogic_channel1.id,
      ports_unit1_temperatureLogic_channel2.id,
      ports_unit1_temperatureLogic_channel3.id,
      ports_unit1_temperatureLogic_channel4.id,
      ports_unit1_pressureLogic_channel1.id,
      ports_unit1_pressureLogic_channel2.id,
      ports_unit1_pressureLogic_channel3.id,
      ports_unit1_pressureLogic_channel4.id,
      ports_unit1_saturationLogic_channel1.id,
      ports_unit1_saturationLogic_channel2.id,
      ports_unit1_saturationLogic_channel3.id,
      ports_unit1_saturationLogic_channel4.id,
      ports_unit2_temperatureLogic_channel1.id,
      ports_unit2_temperatureLogic_channel2.id,
      ports_unit2_temperatureLogic_channel3.id,
      ports_unit2_temperatureLogic_channel4.id,
      ports_unit2_pressureLogic_channel1.id,
      ports_unit2_pressureLogic_channel2.id,
      ports_unit2_pressureLogic_channel3.id,
      ports_unit2_pressureLogic_channel4.id,
      ports_unit2_saturationLogic_channel1.id,
      ports_unit2_saturationLogic_channel2.id,
      ports_unit2_saturationLogic_channel3.id,
      ports_unit2_saturationLogic_channel4.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge {

  var c_initialization_api: Option[InstrumentationMockThread_Initialization_Api] = None()
  var c_operational_api: Option[InstrumentationMockThread_Operational_Api] = None()

  @datatype class EntryPoints(
    InstrumentationMockThread_instrumentationMock_instrumentationMockThread_BridgeId : Art.BridgeId,
    ports_unit1_temperatureLogic_channel1_Id : Art.PortId,
    ports_unit1_temperatureLogic_channel2_Id : Art.PortId,
    ports_unit1_temperatureLogic_channel3_Id : Art.PortId,
    ports_unit1_temperatureLogic_channel4_Id : Art.PortId,
    ports_unit1_pressureLogic_channel1_Id : Art.PortId,
    ports_unit1_pressureLogic_channel2_Id : Art.PortId,
    ports_unit1_pressureLogic_channel3_Id : Art.PortId,
    ports_unit1_pressureLogic_channel4_Id : Art.PortId,
    ports_unit1_saturationLogic_channel1_Id : Art.PortId,
    ports_unit1_saturationLogic_channel2_Id : Art.PortId,
    ports_unit1_saturationLogic_channel3_Id : Art.PortId,
    ports_unit1_saturationLogic_channel4_Id : Art.PortId,
    ports_unit2_temperatureLogic_channel1_Id : Art.PortId,
    ports_unit2_temperatureLogic_channel2_Id : Art.PortId,
    ports_unit2_temperatureLogic_channel3_Id : Art.PortId,
    ports_unit2_temperatureLogic_channel4_Id : Art.PortId,
    ports_unit2_pressureLogic_channel1_Id : Art.PortId,
    ports_unit2_pressureLogic_channel2_Id : Art.PortId,
    ports_unit2_pressureLogic_channel3_Id : Art.PortId,
    ports_unit2_pressureLogic_channel4_Id : Art.PortId,
    ports_unit2_saturationLogic_channel1_Id : Art.PortId,
    ports_unit2_saturationLogic_channel2_Id : Art.PortId,
    ports_unit2_saturationLogic_channel3_Id : Art.PortId,
    ports_unit2_saturationLogic_channel4_Id : Art.PortId,
    dispatchTriggers : Option[ISZ[Art.PortId]],
    initialization_api: InstrumentationMockThread_Initialization_Api,
    operational_api: InstrumentationMockThread_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(ports_unit1_temperatureLogic_channel1_Id,
                                              ports_unit1_temperatureLogic_channel2_Id,
                                              ports_unit1_temperatureLogic_channel3_Id,
                                              ports_unit1_temperatureLogic_channel4_Id,
                                              ports_unit1_pressureLogic_channel1_Id,
                                              ports_unit1_pressureLogic_channel2_Id,
                                              ports_unit1_pressureLogic_channel3_Id,
                                              ports_unit1_pressureLogic_channel4_Id,
                                              ports_unit1_saturationLogic_channel1_Id,
                                              ports_unit1_saturationLogic_channel2_Id,
                                              ports_unit1_saturationLogic_channel3_Id,
                                              ports_unit1_saturationLogic_channel4_Id,
                                              ports_unit2_temperatureLogic_channel1_Id,
                                              ports_unit2_temperatureLogic_channel2_Id,
                                              ports_unit2_temperatureLogic_channel3_Id,
                                              ports_unit2_temperatureLogic_channel4_Id,
                                              ports_unit2_pressureLogic_channel1_Id,
                                              ports_unit2_pressureLogic_channel2_Id,
                                              ports_unit2_pressureLogic_channel3_Id,
                                              ports_unit2_pressureLogic_channel4_Id,
                                              ports_unit2_saturationLogic_channel1_Id,
                                              ports_unit2_saturationLogic_channel2_Id,
                                              ports_unit2_saturationLogic_channel3_Id,
                                              ports_unit2_saturationLogic_channel4_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def initialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: InstrumentationMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      // implement the following method in 'component':  def activate(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      // implement the following method in 'component':  def deactivate(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      // implement the following method in 'component':  def finalise(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.finalise(operational_api)
    }

    def recover(): Unit = {
      // implement the following method in 'component':  def recover(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.recover(operational_api)
    }

    override
    def testInitialise(): Unit = {
      // implement the following method in 'component':  def initialise(api: InstrumentationMockThread_Initialization_Api): Unit = {}
      component.initialise(initialization_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)

      // implement the following in 'component':  def timeTriggered(api: InstrumentationMockThread_Operational_Api): Unit = {}
      component.timeTriggered(operational_api)

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }
  }
}