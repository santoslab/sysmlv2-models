package RTS.Actuation

import org.sireum._
import art.{ArtNative_Ext, Empty}
import RTS._

// This file was auto-generated.  Do not edit
abstract class OrLogic_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_TestApi extends BridgeTestSuite[OrLogic_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_Bridge](Arch.rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic) {

  /** helper function to set the values of all input ports.
   * @param ports_channel1 payload for data port ports_channel1
   * @param ports_channel2 payload for data port ports_channel2
   */
  def put_concrete_inputs(ports_channel1 : Base_Types.Boolean,
                          ports_channel2 : Base_Types.Boolean): Unit = {
    put_ports_channel1(ports_channel1)
    put_ports_channel2(ports_channel2)
  }


  /** helper function to check OrLogic_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_actuate method that will be called with the value of the outgoing data
   *        port 'ports_actuate'.
   */
  def check_concrete_output(ports_actuate: Base_Types.Boolean => B = ports_actuateParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val ports_actuateValue: Base_Types.Boolean = get_ports_actuate().get
    if(!ports_actuate(ports_actuateValue)) {
      testFailures = testFailures :+ st"'ports_actuate' did not match expected: value of the outgoing data port is ${ports_actuateValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_ports_channel1(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_channel1_Id, Base_Types.Boolean_Payload(value))
  }

  // setter for in DataPort
  def put_ports_channel2(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_channel2_Id, Base_Types.Boolean_Payload(value))
  }

  // getter for out DataPort
  def get_ports_actuate(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_ports_actuate_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_actuate.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_actuate_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_actuate_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
