package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class Fan_tcp_fan_TestApi extends BridgeTestSuite[Fan_tcp_fan_Bridge](Arch.tcs_tcp_fan) {

  /** helper function to set the values of all input ports.
   * @param ports_fanCmd payloads for event data port ports_fanCmd.
   *   ART currently supports single element event data queues so
   *   only the last element of ports_fanCmd will be used
   */
  def put_concrete_inputs(ports_fanCmd : ISZ[TempControlAadl.FanCmd.Type]): Unit = {
    for(v <- ports_fanCmd){
      put_ports_fanCmd(v)
    }
  }


  /** helper function to check Fan_tcp_fan's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_fanAck method that will be called with the payloads to be sent
   *        on the outgoing event data port 'ports_fanAck'.
   */
  def check_concrete_output(ports_fanAck: ISZ[TempControlAadl.FanAck.Type] => B = ports_fanAckParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var ports_fanAckValue: ISZ[TempControlAadl.FanAck.Type] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_ports_fanAck().nonEmpty) ports_fanAckValue = ports_fanAckValue :+ get_ports_fanAck().get
    if(!ports_fanAck(ports_fanAckValue)) {
      testFailures = testFailures :+ st"'ports_fanAck' did not match expected: received ${ports_fanAckValue.size} events with the following payloads ${ports_fanAckValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in EventDataPort
  def put_ports_fanCmd(value : TempControlAadl.FanCmd.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_fanCmd_Id, TempControlAadl.FanCmd_Payload(value))
  }

  // getter for out EventDataPort
  def get_ports_fanAck(): Option[TempControlAadl.FanAck.Type] = {
    val value: Option[TempControlAadl.FanAck.Type] = get_ports_fanAck_payload() match {
      case Some(TempControlAadl.FanAck_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_fanAck.  Expecting 'TempControlAadl.FanAck_Payload' but received ${v}")
      case _ => None[TempControlAadl.FanAck.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_ports_fanAck_payload(): Option[TempControlAadl.FanAck_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_fanAck_Id).asInstanceOf[Option[TempControlAadl.FanAck_Payload]]
  }

}
