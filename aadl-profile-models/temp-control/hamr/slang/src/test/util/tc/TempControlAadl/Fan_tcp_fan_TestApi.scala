package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class Fan_tcp_fan_TestApi extends BridgeTestSuite[Fan_tcp_fan_Bridge](Arch.tcs_tcp_fan) {

  /** helper function to set the values of all input ports.
   * @param fanCmd payloads for event data port fanCmd.
   *   ART currently supports single element event data queues so
   *   only the last element of fanCmd will be used
   */
  def put_concrete_inputs(fanCmd : ISZ[TempControlAadl.FanCmd]): Unit = {
    for(v <- fanCmd){
      put_fanCmd(v)
    }
  }


  /** helper function to check Fan_tcp_fan's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param fanAck method that will be called with the payloads to be sent
   *        on the outgoing event data port 'fanAck'.
   */
  def check_concrete_output(fanAck: ISZ[TempControlAadl.FanAck] => B = fanAckParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var fanAckValue: ISZ[TempControlAadl.FanAck] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_fanAck().nonEmpty) fanAckValue = fanAckValue :+ get_fanAck().get
    if(!fanAck(fanAckValue)) {
      testFailures = testFailures :+ st"'fanAck' did not match expected: received ${fanAckValue.size} events with the following payloads ${fanAckValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in EventDataPort
  def put_fanCmd(value : TempControlAadl.FanCmd): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.fanCmd_Id, TempControlAadl.FanCmd_Payload(value))
  }

  // getter for out EventDataPort
  def get_fanAck(): Option[TempControlAadl.FanAck] = {
    val value: Option[TempControlAadl.FanAck] = get_fanAck_payload() match {
      case Some(TempControlAadl.FanAck_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanAck.  Expecting 'TempControlAadl.FanAck_Payload' but received ${v}")
      case _ => None[TempControlAadl.FanAck]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanAck_payload(): Option[TempControlAadl.FanAck_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.fanAck_Id).asInstanceOf[Option[TempControlAadl.FanAck_Payload]]
  }

}
