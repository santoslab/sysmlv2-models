package RTS.Actuation

import org.sireum._
import art.{ArtNative_Ext, Empty}
import RTS._

// This file was auto-generated.  Do not edit
abstract class Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_TestApi extends BridgeTestSuite[Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge](Arch.rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator) {

  /** helper function to set the values of all input ports.
   * @param ports_input payload for data port ports_input
   * @param ports_manualActuatorInput payload for data port ports_manualActuatorInput
   */
  def put_concrete_inputs(ports_input : Base_Types.Boolean,
                          ports_manualActuatorInput : Base_Types.Boolean): Unit = {
    put_ports_input(ports_input)
    put_ports_manualActuatorInput(ports_manualActuatorInput)
  }


  /** helper function to check Actuator_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_output method that will be called with the value of the outgoing data
   *        port 'ports_output'.
   */
  def check_concrete_output(ports_output: Base_Types.Boolean => B = ports_outputParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val ports_outputValue: Base_Types.Boolean = get_ports_output().get
    if(!ports_output(ports_outputValue)) {
      testFailures = testFailures :+ st"'ports_output' did not match expected: value of the outgoing data port is ${ports_outputValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_ports_input(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_input_Id, Base_Types.Boolean_Payload(value))
  }

  // setter for in DataPort
  def put_ports_manualActuatorInput(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_manualActuatorInput_Id, Base_Types.Boolean_Payload(value))
  }

  // getter for out DataPort
  def get_ports_output(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_output_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_output.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_output_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_output_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
