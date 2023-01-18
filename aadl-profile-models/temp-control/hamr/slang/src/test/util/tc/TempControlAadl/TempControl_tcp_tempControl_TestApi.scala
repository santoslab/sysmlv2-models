package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class TempControl_tcp_tempControl_TestApi extends BridgeTestSuite[TempControl_tcp_tempControl_Bridge](Arch.tcs_tcp_tempControl) {

  /** helper function to set the values of all input ports.
   * @param currentTemp payload for data port currentTemp
   * @param tempChanged the number of events to place in the tempChanged event port queue.
   *   ART currently supports single element event queues so at most
   *   one event will be placed in the queue.
   * @param fanAck payloads for event data port fanAck.
   *   ART currently supports single element event data queues so
   *   only the last element of fanAck will be used
   * @param setPoint payloads for event data port setPoint.
   *   ART currently supports single element event data queues so
   *   only the last element of setPoint will be used
   */
  def put_concrete_inputs(currentTemp : TempControlAadl.Temperature,
                          tempChanged : Z,
                          fanAck : ISZ[TempControlAadl.FanAck],
                          setPoint : ISZ[TempControlAadl.Temperature]): Unit = {
    put_currentTemp(currentTemp)
    for(i <- 0 until tempChanged) {
      put_tempChanged()
    }
    for(v <- fanAck){
      put_fanAck(v)
    }
    for(v <- setPoint){
      put_setPoint(v)
    }
  }


  /** helper function to check TempControl_tcp_tempControl's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param fanCmd method that will be called with the payloads to be sent
   *        on the outgoing event data port 'fanCmd'.
   */
  def check_concrete_output(fanCmd: ISZ[TempControlAadl.FanCmd] => B = fanCmdParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var fanCmdValue: ISZ[TempControlAadl.FanCmd] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_fanCmd().nonEmpty) fanCmdValue = fanCmdValue :+ get_fanCmd().get
    if(!fanCmd(fanCmdValue)) {
      testFailures = testFailures :+ st"'fanCmd' did not match expected: received ${fanCmdValue.size} events with the following payloads ${fanCmdValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_currentTemp(value : TempControlAadl.Temperature): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.currentTemp_Id, TempControlAadl.Temperature_Payload(value))
  }

  // setter for in EventPort
  def put_tempChanged(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.tempChanged_Id, Empty())
  }

  // setter for in EventDataPort
  def put_fanAck(value : TempControlAadl.FanAck): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.fanAck_Id, TempControlAadl.FanAck_Payload(value))
  }

  // setter for in EventDataPort
  def put_setPoint(value : TempControlAadl.Temperature): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.setPoint_Id, TempControlAadl.Temperature_Payload(value))
  }

  // getter for out EventDataPort
  def get_fanCmd(): Option[TempControlAadl.FanCmd] = {
    val value: Option[TempControlAadl.FanCmd] = get_fanCmd_payload() match {
      case Some(TempControlAadl.FanCmd_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanCmd.  Expecting 'TempControlAadl.FanCmd_Payload' but received ${v}")
      case _ => None[TempControlAadl.FanCmd]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanCmd_payload(): Option[TempControlAadl.FanCmd_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.fanCmd_Id).asInstanceOf[Option[TempControlAadl.FanCmd_Payload]]
  }

}
