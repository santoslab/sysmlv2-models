package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class TempSensor_tcp_tempSensor_TestApi extends BridgeTestSuite[TempSensor_tcp_tempSensor_Bridge](Arch.tcs_tcp_tempSensor) {

  /** helper function to check TempSensor_tcp_tempSensor's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_currentTemp method that will be called with the value of the outgoing data
   *        port 'ports_currentTemp'.
   * @param ports_tempChanged method that will be called with the number of events to be sent
   *        on the outgoing event port 'ports_tempChanged'.
   */
  def check_concrete_output(ports_currentTemp: TempControlAadl.Temperature => B = ports_currentTempParam => {T},
                            ports_tempChanged: Z => B = ports_tempChangedParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val ports_currentTempValue: TempControlAadl.Temperature = get_ports_currentTemp().get
    if(!ports_currentTemp(ports_currentTempValue)) {
      testFailures = testFailures :+ st"'ports_currentTemp' did not match expected: value of the outgoing data port is ${ports_currentTempValue}"
    }
    // TODO: event port getter should return the number of events in
    //       the output queue when queue sizes > 1 support is added to ART
    val ports_tempChangedValue: Z = if(get_ports_tempChanged().nonEmpty) z"1" else z"0"
    if(!ports_tempChanged(ports_tempChangedValue)) {
      testFailures = testFailures :+ st"'ports_tempChanged' did not match expected: ${ports_tempChangedValue} events were in the outgoing event queue"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_ports_currentTemp(): Option[TempControlAadl.Temperature] = {
    val value: Option[TempControlAadl.Temperature] = get_ports_currentTemp_payload() match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_currentTemp.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_ports_currentTemp_payload(): Option[TempControlAadl.Temperature_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_currentTemp_Id).asInstanceOf[Option[TempControlAadl.Temperature_Payload]]
  }

  // getter for out EventPort
  def get_ports_tempChanged(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ports_tempChanged_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ports_tempChanged.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ports_tempChanged_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_tempChanged_Id).asInstanceOf[Option[Empty]]
  }

}
