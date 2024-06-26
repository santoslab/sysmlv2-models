// #Sireum

package RTS

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._
import art.Art.BridgeId._
import art.Art.PortId._

// This file was auto-generated.  Do not edit

object Arch {
  val rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"0", name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"1", name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"2", name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"3", name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"4", name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge(
      id = bridgeId"0",
      name = "rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"5", name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"6", name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"7", name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"8", name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"9", name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Bridge(
      id = bridgeId"1",
      name = "rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"10", name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"11", name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"12", name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"13", name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"14", name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_Bridge(
      id = bridgeId"2",
      name = "rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic : RTS.Actuation.OrLogic_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"15", name = "rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"16", name = "rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_ports_channel2", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"17", name = "rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_Bridge(
      id = bridgeId"3",
      name = "rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"18", name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"19", name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"20", name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"21", name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"22", name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_Bridge(
      id = bridgeId"4",
      name = "rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"23", name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"24", name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"25", name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"26", name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"27", name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_Bridge(
      id = bridgeId"5",
      name = "rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"28", name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"29", name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_ports_channel2", mode = DataIn)
    val ports_channel3 = Port[Base_Types.Boolean] (id = portId"30", name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_ports_channel3", mode = DataIn)
    val ports_channel4 = Port[Base_Types.Boolean] (id = portId"31", name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_ports_channel4", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"32", name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_Bridge(
      id = bridgeId"6",
      name = "rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_channel3 = ports_channel3,
      ports_channel4 = ports_channel4,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic : RTS.Actuation.OrLogic_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"33", name = "rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"34", name = "rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_ports_channel2", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"35", name = "rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_Bridge(
      id = bridgeId"7",
      name = "rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic : RTS.Actuation.OrLogic_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"36", name = "rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"37", name = "rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_ports_channel2", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"38", name = "rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_Bridge(
      id = bridgeId"8",
      name = "rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator : RTS.Actuation.Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge = {
    val ports_input = Port[Base_Types.Boolean] (id = portId"39", name = "rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_ports_input", mode = DataIn)
    val ports_manualActuatorInput = Port[Base_Types.Boolean] (id = portId"40", name = "rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_ports_manualActuatorInput", mode = DataIn)
    val ports_output = Port[Base_Types.Boolean] (id = portId"41", name = "rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_ports_output", mode = DataOut)

    RTS.Actuation.Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge(
      id = bridgeId"9",
      name = "rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_input = ports_input,
      ports_manualActuatorInput = ports_manualActuatorInput,
      ports_output = ports_output
    )
  }
  val rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic : RTS.Actuation.OrLogic_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Bridge = {
    val ports_channel1 = Port[Base_Types.Boolean] (id = portId"42", name = "rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_ports_channel1", mode = DataIn)
    val ports_channel2 = Port[Base_Types.Boolean] (id = portId"43", name = "rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_ports_channel2", mode = DataIn)
    val ports_actuate = Port[Base_Types.Boolean] (id = portId"44", name = "rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_ports_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Bridge(
      id = bridgeId"10",
      name = "rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_channel1 = ports_channel1,
      ports_channel2 = ports_channel2,
      ports_actuate = ports_actuate
    )
  }
  val rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator : RTS.Actuation.Actuator_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge = {
    val ports_input = Port[Base_Types.Boolean] (id = portId"45", name = "rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_ports_input", mode = DataIn)
    val ports_manualActuatorInput = Port[Base_Types.Boolean] (id = portId"46", name = "rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_ports_manualActuatorInput", mode = DataIn)
    val ports_output = Port[Base_Types.Boolean] (id = portId"47", name = "rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_ports_output", mode = DataOut)

    RTS.Actuation.Actuator_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge(
      id = bridgeId"11",
      name = "rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_input = ports_input,
      ports_manualActuatorInput = ports_manualActuatorInput,
      ports_output = ports_output
    )
  }
  val rts_instrumentationMock_instrumentationMockThread : RTS.Instrumentation.InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge = {
    val ports_unit1_temperatureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"48", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_temperatureLogic_channel1", mode = DataOut)
    val ports_unit1_temperatureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"49", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_temperatureLogic_channel2", mode = DataOut)
    val ports_unit1_temperatureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"50", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_temperatureLogic_channel3", mode = DataOut)
    val ports_unit1_temperatureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"51", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_temperatureLogic_channel4", mode = DataOut)
    val ports_unit1_pressureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"52", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_pressureLogic_channel1", mode = DataOut)
    val ports_unit1_pressureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"53", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_pressureLogic_channel2", mode = DataOut)
    val ports_unit1_pressureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"54", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_pressureLogic_channel3", mode = DataOut)
    val ports_unit1_pressureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"55", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_pressureLogic_channel4", mode = DataOut)
    val ports_unit1_saturationLogic_channel1 = Port[Base_Types.Boolean] (id = portId"56", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_saturationLogic_channel1", mode = DataOut)
    val ports_unit1_saturationLogic_channel2 = Port[Base_Types.Boolean] (id = portId"57", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_saturationLogic_channel2", mode = DataOut)
    val ports_unit1_saturationLogic_channel3 = Port[Base_Types.Boolean] (id = portId"58", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_saturationLogic_channel3", mode = DataOut)
    val ports_unit1_saturationLogic_channel4 = Port[Base_Types.Boolean] (id = portId"59", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit1_saturationLogic_channel4", mode = DataOut)
    val ports_unit2_temperatureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"60", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_temperatureLogic_channel1", mode = DataOut)
    val ports_unit2_temperatureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"61", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_temperatureLogic_channel2", mode = DataOut)
    val ports_unit2_temperatureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"62", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_temperatureLogic_channel3", mode = DataOut)
    val ports_unit2_temperatureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"63", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_temperatureLogic_channel4", mode = DataOut)
    val ports_unit2_pressureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"64", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_pressureLogic_channel1", mode = DataOut)
    val ports_unit2_pressureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"65", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_pressureLogic_channel2", mode = DataOut)
    val ports_unit2_pressureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"66", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_pressureLogic_channel3", mode = DataOut)
    val ports_unit2_pressureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"67", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_pressureLogic_channel4", mode = DataOut)
    val ports_unit2_saturationLogic_channel1 = Port[Base_Types.Boolean] (id = portId"68", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_saturationLogic_channel1", mode = DataOut)
    val ports_unit2_saturationLogic_channel2 = Port[Base_Types.Boolean] (id = portId"69", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_saturationLogic_channel2", mode = DataOut)
    val ports_unit2_saturationLogic_channel3 = Port[Base_Types.Boolean] (id = portId"70", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_saturationLogic_channel3", mode = DataOut)
    val ports_unit2_saturationLogic_channel4 = Port[Base_Types.Boolean] (id = portId"71", name = "rts_instrumentationMock_instrumentationMockThread_ports_unit2_saturationLogic_channel4", mode = DataOut)

    RTS.Instrumentation.InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge(
      id = bridgeId"12",
      name = "rts_instrumentationMock_instrumentationMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_unit1_temperatureLogic_channel1 = ports_unit1_temperatureLogic_channel1,
      ports_unit1_temperatureLogic_channel2 = ports_unit1_temperatureLogic_channel2,
      ports_unit1_temperatureLogic_channel3 = ports_unit1_temperatureLogic_channel3,
      ports_unit1_temperatureLogic_channel4 = ports_unit1_temperatureLogic_channel4,
      ports_unit1_pressureLogic_channel1 = ports_unit1_pressureLogic_channel1,
      ports_unit1_pressureLogic_channel2 = ports_unit1_pressureLogic_channel2,
      ports_unit1_pressureLogic_channel3 = ports_unit1_pressureLogic_channel3,
      ports_unit1_pressureLogic_channel4 = ports_unit1_pressureLogic_channel4,
      ports_unit1_saturationLogic_channel1 = ports_unit1_saturationLogic_channel1,
      ports_unit1_saturationLogic_channel2 = ports_unit1_saturationLogic_channel2,
      ports_unit1_saturationLogic_channel3 = ports_unit1_saturationLogic_channel3,
      ports_unit1_saturationLogic_channel4 = ports_unit1_saturationLogic_channel4,
      ports_unit2_temperatureLogic_channel1 = ports_unit2_temperatureLogic_channel1,
      ports_unit2_temperatureLogic_channel2 = ports_unit2_temperatureLogic_channel2,
      ports_unit2_temperatureLogic_channel3 = ports_unit2_temperatureLogic_channel3,
      ports_unit2_temperatureLogic_channel4 = ports_unit2_temperatureLogic_channel4,
      ports_unit2_pressureLogic_channel1 = ports_unit2_pressureLogic_channel1,
      ports_unit2_pressureLogic_channel2 = ports_unit2_pressureLogic_channel2,
      ports_unit2_pressureLogic_channel3 = ports_unit2_pressureLogic_channel3,
      ports_unit2_pressureLogic_channel4 = ports_unit2_pressureLogic_channel4,
      ports_unit2_saturationLogic_channel1 = ports_unit2_saturationLogic_channel1,
      ports_unit2_saturationLogic_channel2 = ports_unit2_saturationLogic_channel2,
      ports_unit2_saturationLogic_channel3 = ports_unit2_saturationLogic_channel3,
      ports_unit2_saturationLogic_channel4 = ports_unit2_saturationLogic_channel4
    )
  }
  val rts_eventControlMock_eventControlMockThread : RTS.EventControl.EventControlMockThread_eventControlMock_eventControlMockThread_Bridge = {
    val ports_manualActuatorInput1 = Port[Base_Types.Boolean] (id = portId"72", name = "rts_eventControlMock_eventControlMockThread_ports_manualActuatorInput1", mode = DataOut)
    val ports_manualActuatorInput2 = Port[Base_Types.Boolean] (id = portId"73", name = "rts_eventControlMock_eventControlMockThread_ports_manualActuatorInput2", mode = DataOut)

    RTS.EventControl.EventControlMockThread_eventControlMock_eventControlMockThread_Bridge(
      id = bridgeId"13",
      name = "rts_eventControlMock_eventControlMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_manualActuatorInput1 = ports_manualActuatorInput1,
      ports_manualActuatorInput2 = ports_manualActuatorInput2
    )
  }
  val rts_actuatorsMock_actuatorsMockThread : RTS.Actuators.ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge = {
    val ports_tempPressureActuate = Port[Base_Types.Boolean] (id = portId"74", name = "rts_actuatorsMock_actuatorsMockThread_ports_tempPressureActuate", mode = DataIn)
    val ports_saturationActuate = Port[Base_Types.Boolean] (id = portId"75", name = "rts_actuatorsMock_actuatorsMockThread_ports_saturationActuate", mode = DataIn)

    RTS.Actuators.ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge(
      id = bridgeId"14",
      name = "rts_actuatorsMock_actuatorsMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_tempPressureActuate = ports_tempPressureActuate,
      ports_saturationActuate = ports_saturationActuate
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = IS[Art.BridgeId, Bridge] (rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic, rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic, rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic, rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic, rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator, rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic, rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator, rts_instrumentationMock_instrumentationMockThread, rts_eventControlMock_eventControlMockThread, rts_actuatorsMock_actuatorsMockThread),

      connections = IS[Art.ConnectionId, UConnection] (Connection(from = rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.ports_channel1),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.ports_channel2),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.ports_channel1),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.ports_channel2),
                                                       Connection(from = rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.ports_actuate, to = rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.ports_input),
                                                       Connection(from = rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.ports_actuate, to = rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.ports_input),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.ports_channel1),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.ports_actuate, to = rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.ports_channel1),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.ports_actuate, to = rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.ports_channel2),
                                                       Connection(from = rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.ports_actuate, to = rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_temperatureLogic_channel1, to = rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_temperatureLogic_channel2, to = rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_temperatureLogic_channel3, to = rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_temperatureLogic_channel4, to = rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_pressureLogic_channel1, to = rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_pressureLogic_channel2, to = rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_pressureLogic_channel3, to = rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_pressureLogic_channel4, to = rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_saturationLogic_channel1, to = rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_saturationLogic_channel2, to = rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_saturationLogic_channel3, to = rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit1_saturationLogic_channel4, to = rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_temperatureLogic_channel1, to = rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_temperatureLogic_channel2, to = rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_temperatureLogic_channel3, to = rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_temperatureLogic_channel4, to = rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_pressureLogic_channel1, to = rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_pressureLogic_channel2, to = rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_pressureLogic_channel3, to = rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_pressureLogic_channel4, to = rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_saturationLogic_channel1, to = rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.ports_channel1),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_saturationLogic_channel2, to = rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.ports_channel2),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_saturationLogic_channel3, to = rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.ports_channel3),
                                                       Connection(from = rts_instrumentationMock_instrumentationMockThread.ports_unit2_saturationLogic_channel4, to = rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.ports_channel4),
                                                       Connection(from = rts_eventControlMock_eventControlMockThread.ports_manualActuatorInput1, to = rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.ports_manualActuatorInput),
                                                       Connection(from = rts_eventControlMock_eventControlMockThread.ports_manualActuatorInput2, to = rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.ports_manualActuatorInput),
                                                       Connection(from = rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.ports_output, to = rts_actuatorsMock_actuatorsMockThread.ports_tempPressureActuate),
                                                       Connection(from = rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.ports_output, to = rts_actuatorsMock_actuatorsMockThread.ports_saturationActuate))
    )
  }
}
