package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class OperatorInterface_tcp_opInterface_TestApi extends BridgeTestSuite[OperatorInterface_tcp_opInterface_Bridge](Arch.tcs_tcp_opInterface) {

  /** helper function to set the values of all input ports.
   * @param ports_currentTemp payload for data port ports_currentTemp
   */
  def put_concrete_inputs(ports_currentTemp : TempControlAadl.Temperature): Unit = {
    put_ports_currentTemp(ports_currentTemp)
  }


  /** helper function to check OperatorInterface_tcp_opInterface's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param ports_setPoint method that will be called with the payloads to be sent
   *        on the outgoing event data port 'ports_setPoint'.
   */
  def check_concrete_output(ports_setPoint: ISZ[TempControlAadl.Temperature] => B = ports_setPointParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var ports_setPointValue: ISZ[TempControlAadl.Temperature] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_ports_setPoint().nonEmpty) ports_setPointValue = ports_setPointValue :+ get_ports_setPoint().get
    if(!ports_setPoint(ports_setPointValue)) {
      testFailures = testFailures :+ st"'ports_setPoint' did not match expected: received ${ports_setPointValue.size} events with the following payloads ${ports_setPointValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_ports_currentTemp(value : TempControlAadl.Temperature): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_currentTemp_Id, TempControlAadl.Temperature_Payload(value))
  }

  // getter for out EventDataPort
  def get_ports_setPoint(): Option[TempControlAadl.Temperature] = {
    val value: Option[TempControlAadl.Temperature] = get_ports_setPoint_payload() match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port ports_setPoint.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_ports_setPoint_payload(): Option[TempControlAadl.Temperature_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ports_setPoint_Id).asInstanceOf[Option[TempControlAadl.Temperature_Payload]]
  }

}
