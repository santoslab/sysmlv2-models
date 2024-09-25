package RTS.Instrumentation

import org.sireum._
import art.{ArtNative_Ext, Empty}
import RTS._

// This file was auto-generated.  Do not edit
abstract class InstrumentationMockThread_instrumentationMock_instrumentationMockThread_TestApi extends BridgeTestSuite[InstrumentationMockThread_instrumentationMock_instrumentationMockThread_Bridge](Arch.rts_instrumentationMock_instrumentationMockThread) {

  /** helper function to check InstrumentationMockThread_instrumentationMock_instrumentationMockThread's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_unit1_temperatureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_temperatureLogic_channel1'.
   * @param ports_unit1_temperatureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_temperatureLogic_channel2'.
   * @param ports_unit1_temperatureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_temperatureLogic_channel3'.
   * @param ports_unit1_temperatureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_temperatureLogic_channel4'.
   * @param ports_unit1_pressureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_pressureLogic_channel1'.
   * @param ports_unit1_pressureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_pressureLogic_channel2'.
   * @param ports_unit1_pressureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_pressureLogic_channel3'.
   * @param ports_unit1_pressureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_pressureLogic_channel4'.
   * @param ports_unit1_saturationLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_saturationLogic_channel1'.
   * @param ports_unit1_saturationLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_saturationLogic_channel2'.
   * @param ports_unit1_saturationLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_saturationLogic_channel3'.
   * @param ports_unit1_saturationLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit1_saturationLogic_channel4'.
   * @param ports_unit2_temperatureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_temperatureLogic_channel1'.
   * @param ports_unit2_temperatureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_temperatureLogic_channel2'.
   * @param ports_unit2_temperatureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_temperatureLogic_channel3'.
   * @param ports_unit2_temperatureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_temperatureLogic_channel4'.
   * @param ports_unit2_pressureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_pressureLogic_channel1'.
   * @param ports_unit2_pressureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_pressureLogic_channel2'.
   * @param ports_unit2_pressureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_pressureLogic_channel3'.
   * @param ports_unit2_pressureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_pressureLogic_channel4'.
   * @param ports_unit2_saturationLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_saturationLogic_channel1'.
   * @param ports_unit2_saturationLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_saturationLogic_channel2'.
   * @param ports_unit2_saturationLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_saturationLogic_channel3'.
   * @param ports_unit2_saturationLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'ports_unit2_saturationLogic_channel4'.
   */
  def check_concrete_output(ports_unit1_temperatureLogic_channel1: Base_Types.Boolean => B = ports_unit1_temperatureLogic_channel1Param => {T},
                            ports_unit1_temperatureLogic_channel2: Base_Types.Boolean => B = ports_unit1_temperatureLogic_channel2Param => {T},
                            ports_unit1_temperatureLogic_channel3: Base_Types.Boolean => B = ports_unit1_temperatureLogic_channel3Param => {T},
                            ports_unit1_temperatureLogic_channel4: Base_Types.Boolean => B = ports_unit1_temperatureLogic_channel4Param => {T},
                            ports_unit1_pressureLogic_channel1: Base_Types.Boolean => B = ports_unit1_pressureLogic_channel1Param => {T},
                            ports_unit1_pressureLogic_channel2: Base_Types.Boolean => B = ports_unit1_pressureLogic_channel2Param => {T},
                            ports_unit1_pressureLogic_channel3: Base_Types.Boolean => B = ports_unit1_pressureLogic_channel3Param => {T},
                            ports_unit1_pressureLogic_channel4: Base_Types.Boolean => B = ports_unit1_pressureLogic_channel4Param => {T},
                            ports_unit1_saturationLogic_channel1: Base_Types.Boolean => B = ports_unit1_saturationLogic_channel1Param => {T},
                            ports_unit1_saturationLogic_channel2: Base_Types.Boolean => B = ports_unit1_saturationLogic_channel2Param => {T},
                            ports_unit1_saturationLogic_channel3: Base_Types.Boolean => B = ports_unit1_saturationLogic_channel3Param => {T},
                            ports_unit1_saturationLogic_channel4: Base_Types.Boolean => B = ports_unit1_saturationLogic_channel4Param => {T},
                            ports_unit2_temperatureLogic_channel1: Base_Types.Boolean => B = ports_unit2_temperatureLogic_channel1Param => {T},
                            ports_unit2_temperatureLogic_channel2: Base_Types.Boolean => B = ports_unit2_temperatureLogic_channel2Param => {T},
                            ports_unit2_temperatureLogic_channel3: Base_Types.Boolean => B = ports_unit2_temperatureLogic_channel3Param => {T},
                            ports_unit2_temperatureLogic_channel4: Base_Types.Boolean => B = ports_unit2_temperatureLogic_channel4Param => {T},
                            ports_unit2_pressureLogic_channel1: Base_Types.Boolean => B = ports_unit2_pressureLogic_channel1Param => {T},
                            ports_unit2_pressureLogic_channel2: Base_Types.Boolean => B = ports_unit2_pressureLogic_channel2Param => {T},
                            ports_unit2_pressureLogic_channel3: Base_Types.Boolean => B = ports_unit2_pressureLogic_channel3Param => {T},
                            ports_unit2_pressureLogic_channel4: Base_Types.Boolean => B = ports_unit2_pressureLogic_channel4Param => {T},
                            ports_unit2_saturationLogic_channel1: Base_Types.Boolean => B = ports_unit2_saturationLogic_channel1Param => {T},
                            ports_unit2_saturationLogic_channel2: Base_Types.Boolean => B = ports_unit2_saturationLogic_channel2Param => {T},
                            ports_unit2_saturationLogic_channel3: Base_Types.Boolean => B = ports_unit2_saturationLogic_channel3Param => {T},
                            ports_unit2_saturationLogic_channel4: Base_Types.Boolean => B = ports_unit2_saturationLogic_channel4Param => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val ports_unit1_temperatureLogic_channel1Value: Base_Types.Boolean = get_ports_unit1_temperatureLogic_channel1().get
    if(!ports_unit1_temperatureLogic_channel1(ports_unit1_temperatureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit1_temperatureLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit1_temperatureLogic_channel1Value}"
    }
    val ports_unit1_temperatureLogic_channel2Value: Base_Types.Boolean = get_ports_unit1_temperatureLogic_channel2().get
    if(!ports_unit1_temperatureLogic_channel2(ports_unit1_temperatureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit1_temperatureLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit1_temperatureLogic_channel2Value}"
    }
    val ports_unit1_temperatureLogic_channel3Value: Base_Types.Boolean = get_ports_unit1_temperatureLogic_channel3().get
    if(!ports_unit1_temperatureLogic_channel3(ports_unit1_temperatureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit1_temperatureLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit1_temperatureLogic_channel3Value}"
    }
    val ports_unit1_temperatureLogic_channel4Value: Base_Types.Boolean = get_ports_unit1_temperatureLogic_channel4().get
    if(!ports_unit1_temperatureLogic_channel4(ports_unit1_temperatureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit1_temperatureLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit1_temperatureLogic_channel4Value}"
    }
    val ports_unit1_pressureLogic_channel1Value: Base_Types.Boolean = get_ports_unit1_pressureLogic_channel1().get
    if(!ports_unit1_pressureLogic_channel1(ports_unit1_pressureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit1_pressureLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit1_pressureLogic_channel1Value}"
    }
    val ports_unit1_pressureLogic_channel2Value: Base_Types.Boolean = get_ports_unit1_pressureLogic_channel2().get
    if(!ports_unit1_pressureLogic_channel2(ports_unit1_pressureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit1_pressureLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit1_pressureLogic_channel2Value}"
    }
    val ports_unit1_pressureLogic_channel3Value: Base_Types.Boolean = get_ports_unit1_pressureLogic_channel3().get
    if(!ports_unit1_pressureLogic_channel3(ports_unit1_pressureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit1_pressureLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit1_pressureLogic_channel3Value}"
    }
    val ports_unit1_pressureLogic_channel4Value: Base_Types.Boolean = get_ports_unit1_pressureLogic_channel4().get
    if(!ports_unit1_pressureLogic_channel4(ports_unit1_pressureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit1_pressureLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit1_pressureLogic_channel4Value}"
    }
    val ports_unit1_saturationLogic_channel1Value: Base_Types.Boolean = get_ports_unit1_saturationLogic_channel1().get
    if(!ports_unit1_saturationLogic_channel1(ports_unit1_saturationLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit1_saturationLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit1_saturationLogic_channel1Value}"
    }
    val ports_unit1_saturationLogic_channel2Value: Base_Types.Boolean = get_ports_unit1_saturationLogic_channel2().get
    if(!ports_unit1_saturationLogic_channel2(ports_unit1_saturationLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit1_saturationLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit1_saturationLogic_channel2Value}"
    }
    val ports_unit1_saturationLogic_channel3Value: Base_Types.Boolean = get_ports_unit1_saturationLogic_channel3().get
    if(!ports_unit1_saturationLogic_channel3(ports_unit1_saturationLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit1_saturationLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit1_saturationLogic_channel3Value}"
    }
    val ports_unit1_saturationLogic_channel4Value: Base_Types.Boolean = get_ports_unit1_saturationLogic_channel4().get
    if(!ports_unit1_saturationLogic_channel4(ports_unit1_saturationLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit1_saturationLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit1_saturationLogic_channel4Value}"
    }
    val ports_unit2_temperatureLogic_channel1Value: Base_Types.Boolean = get_ports_unit2_temperatureLogic_channel1().get
    if(!ports_unit2_temperatureLogic_channel1(ports_unit2_temperatureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit2_temperatureLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit2_temperatureLogic_channel1Value}"
    }
    val ports_unit2_temperatureLogic_channel2Value: Base_Types.Boolean = get_ports_unit2_temperatureLogic_channel2().get
    if(!ports_unit2_temperatureLogic_channel2(ports_unit2_temperatureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit2_temperatureLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit2_temperatureLogic_channel2Value}"
    }
    val ports_unit2_temperatureLogic_channel3Value: Base_Types.Boolean = get_ports_unit2_temperatureLogic_channel3().get
    if(!ports_unit2_temperatureLogic_channel3(ports_unit2_temperatureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit2_temperatureLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit2_temperatureLogic_channel3Value}"
    }
    val ports_unit2_temperatureLogic_channel4Value: Base_Types.Boolean = get_ports_unit2_temperatureLogic_channel4().get
    if(!ports_unit2_temperatureLogic_channel4(ports_unit2_temperatureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit2_temperatureLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit2_temperatureLogic_channel4Value}"
    }
    val ports_unit2_pressureLogic_channel1Value: Base_Types.Boolean = get_ports_unit2_pressureLogic_channel1().get
    if(!ports_unit2_pressureLogic_channel1(ports_unit2_pressureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit2_pressureLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit2_pressureLogic_channel1Value}"
    }
    val ports_unit2_pressureLogic_channel2Value: Base_Types.Boolean = get_ports_unit2_pressureLogic_channel2().get
    if(!ports_unit2_pressureLogic_channel2(ports_unit2_pressureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit2_pressureLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit2_pressureLogic_channel2Value}"
    }
    val ports_unit2_pressureLogic_channel3Value: Base_Types.Boolean = get_ports_unit2_pressureLogic_channel3().get
    if(!ports_unit2_pressureLogic_channel3(ports_unit2_pressureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit2_pressureLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit2_pressureLogic_channel3Value}"
    }
    val ports_unit2_pressureLogic_channel4Value: Base_Types.Boolean = get_ports_unit2_pressureLogic_channel4().get
    if(!ports_unit2_pressureLogic_channel4(ports_unit2_pressureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit2_pressureLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit2_pressureLogic_channel4Value}"
    }
    val ports_unit2_saturationLogic_channel1Value: Base_Types.Boolean = get_ports_unit2_saturationLogic_channel1().get
    if(!ports_unit2_saturationLogic_channel1(ports_unit2_saturationLogic_channel1Value)) {
      testFailures = testFailures :+ st"'ports_unit2_saturationLogic_channel1' did not match expected: value of the outgoing data port is ${ports_unit2_saturationLogic_channel1Value}"
    }
    val ports_unit2_saturationLogic_channel2Value: Base_Types.Boolean = get_ports_unit2_saturationLogic_channel2().get
    if(!ports_unit2_saturationLogic_channel2(ports_unit2_saturationLogic_channel2Value)) {
      testFailures = testFailures :+ st"'ports_unit2_saturationLogic_channel2' did not match expected: value of the outgoing data port is ${ports_unit2_saturationLogic_channel2Value}"
    }
    val ports_unit2_saturationLogic_channel3Value: Base_Types.Boolean = get_ports_unit2_saturationLogic_channel3().get
    if(!ports_unit2_saturationLogic_channel3(ports_unit2_saturationLogic_channel3Value)) {
      testFailures = testFailures :+ st"'ports_unit2_saturationLogic_channel3' did not match expected: value of the outgoing data port is ${ports_unit2_saturationLogic_channel3Value}"
    }
    val ports_unit2_saturationLogic_channel4Value: Base_Types.Boolean = get_ports_unit2_saturationLogic_channel4().get
    if(!ports_unit2_saturationLogic_channel4(ports_unit2_saturationLogic_channel4Value)) {
      testFailures = testFailures :+ st"'ports_unit2_saturationLogic_channel4' did not match expected: value of the outgoing data port is ${ports_unit2_saturationLogic_channel4Value}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_temperatureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_temperatureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_temperatureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_temperatureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_temperatureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_temperatureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_temperatureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_temperatureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_temperatureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_temperatureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_temperatureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_temperatureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_temperatureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_pressureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_pressureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_pressureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_pressureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_pressureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_pressureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_pressureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_pressureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_pressureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_pressureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_pressureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_pressureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_pressureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_pressureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_pressureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_pressureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_pressureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_pressureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_pressureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_pressureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_saturationLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_saturationLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_saturationLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_saturationLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_saturationLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_saturationLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_saturationLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_saturationLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_saturationLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_saturationLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_saturationLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_saturationLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_saturationLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_saturationLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_saturationLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit1_saturationLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit1_saturationLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit1_saturationLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit1_saturationLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit1_saturationLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_temperatureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_temperatureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_temperatureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_temperatureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_temperatureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_temperatureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_temperatureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_temperatureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_temperatureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_temperatureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_temperatureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_temperatureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_temperatureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_pressureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_pressureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_pressureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_pressureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_pressureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_pressureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_pressureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_pressureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_pressureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_pressureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_pressureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_pressureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_pressureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_pressureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_pressureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_pressureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_pressureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_pressureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_pressureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_pressureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_saturationLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_saturationLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_saturationLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_saturationLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_saturationLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_saturationLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_saturationLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_saturationLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_saturationLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_saturationLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_saturationLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_saturationLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_saturationLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_saturationLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_saturationLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_unit2_saturationLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_unit2_saturationLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_unit2_saturationLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_unit2_saturationLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_unit2_saturationLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
