package RTS.EventControl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import RTS._

// This file was auto-generated.  Do not edit
abstract class EventControlMockThread_eventControlMock_eventControlMockThread_TestApi extends BridgeTestSuite[EventControlMockThread_eventControlMock_eventControlMockThread_Bridge](Arch.rts_eventControlMock_eventControlMockThread) {

  /** helper function to check EventControlMockThread_eventControlMock_eventControlMockThread's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_manualActuatorInput1 method that will be called with the value of the outgoing data
   *        port 'ports_manualActuatorInput1'.
   * @param ports_manualActuatorInput2 method that will be called with the value of the outgoing data
   *        port 'ports_manualActuatorInput2'.
   */
  def check_concrete_output(ports_manualActuatorInput1: Base_Types.Boolean => B = ports_manualActuatorInput1Param => {T},
                            ports_manualActuatorInput2: Base_Types.Boolean => B = ports_manualActuatorInput2Param => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val ports_manualActuatorInput1Value: Base_Types.Boolean = get_ports_manualActuatorInput1().get
    if(!ports_manualActuatorInput1(ports_manualActuatorInput1Value)) {
      testFailures = testFailures :+ st"'ports_manualActuatorInput1' did not match expected: value of the outgoing data port is ${ports_manualActuatorInput1Value}"
    }
    val ports_manualActuatorInput2Value: Base_Types.Boolean = get_ports_manualActuatorInput2().get
    if(!ports_manualActuatorInput2(ports_manualActuatorInput2Value)) {
      testFailures = testFailures :+ st"'ports_manualActuatorInput2' did not match expected: value of the outgoing data port is ${ports_manualActuatorInput2Value}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_ports_manualActuatorInput1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_manualActuatorInput1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_manualActuatorInput1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_manualActuatorInput1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_manualActuatorInput1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_ports_manualActuatorInput2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_manualActuatorInput2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_manualActuatorInput2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_manualActuatorInput2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_manualActuatorInput2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
