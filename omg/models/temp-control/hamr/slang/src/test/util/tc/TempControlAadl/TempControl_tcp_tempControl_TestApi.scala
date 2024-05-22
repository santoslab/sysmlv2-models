package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class TempControl_tcp_tempControl_TestApi extends BridgeTestSuite[TempControl_tcp_tempControl_Bridge](Arch.tcs_tcp_tempControl) {

  /** helper function to set the values of all input ports.
   * @param ports_currentTemp payload for data port ports_currentTemp
   * @param ports_tempChanged the number of events to place in the ports_tempChanged event port queue.
   *   ART currently supports single element event queues so at most
   *   one event will be placed in the queue.
   * @param ports_fanAck payloads for event data port ports_fanAck.
   *   ART currently supports single element event data queues so
   *   only the last element of ports_fanAck will be used
   * @param ports_setPoint payloads for event data port ports_setPoint.
   *   ART currently supports single element event data queues so
   *   only the last element of ports_setPoint will be used
   */
  def put_concrete_inputs(ports_currentTemp : TempControlAadl.Temperature,
                          ports_tempChanged : Z,
                          ports_fanAck : ISZ[TempControlAadl.FanAck.Type],
                          ports_setPoint : ISZ[TempControlAadl.SetPoint]): Unit = {
    put_ports_currentTemp(ports_currentTemp)
    for(i <- 0 until ports_tempChanged) {
      put_ports_tempChanged()
    }
    for(v <- ports_fanAck){
      put_ports_fanAck(v)
    }
    for(v <- ports_setPoint){
      put_ports_setPoint(v)
    }
  }


  /** helper function to check TempControl_tcp_tempControl's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_fanCmd method that will be called with the payloads to be sent
   *        on the outgoing event data port 'ports_fanCmd'.
   */
  def check_concrete_output(ports_fanCmd: ISZ[TempControlAadl.FanCmd.Type] => B = ports_fanCmdParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var ports_fanCmdValue: ISZ[TempControlAadl.FanCmd.Type] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_ports_fanCmd().nonEmpty) ports_fanCmdValue = ports_fanCmdValue :+ get_ports_fanCmd().get
    if(!ports_fanCmd(ports_fanCmdValue)) {
      testFailures = testFailures :+ st"'ports_fanCmd' did not match expected: received ${ports_fanCmdValue.size} events with the following payloads ${ports_fanCmdValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_ports_currentTemp(value : TempControlAadl.Temperature): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_currentTemp_Id, TempControlAadl.Temperature_Payload(value))
  }

  // setter for in EventPort
  def put_ports_tempChanged(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_tempChanged_Id, Empty())
  }

  // setter for in EventDataPort
  def put_ports_fanAck(value : TempControlAadl.FanAck.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_fanAck_Id, TempControlAadl.FanAck_Payload(value))
  }

  // setter for in EventDataPort
  def put_ports_setPoint(value : TempControlAadl.SetPoint): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_setPoint_Id, TempControlAadl.SetPoint_Payload(value))
  }

  // getter for out EventDataPort
  def get_ports_fanCmd(): Option[TempControlAadl.FanCmd.Type] = {
    val value: Option[TempControlAadl.FanCmd.Type] = get_ports_fanCmd_payload() match {
      case Some(TempControlAadl.FanCmd_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_fanCmd.  Expecting 'TempControlAadl.FanCmd_Payload' but received ${v}")
      case _ => None[TempControlAadl.FanCmd.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_ports_fanCmd_payload(): Option[TempControlAadl.FanCmd_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_fanCmd_Id).asInstanceOf[Option[TempControlAadl.FanCmd_Payload]]
  }

}
