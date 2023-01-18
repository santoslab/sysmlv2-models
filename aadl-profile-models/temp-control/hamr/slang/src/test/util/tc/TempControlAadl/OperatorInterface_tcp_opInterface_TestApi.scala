package tc.TempControlAadl

import org.sireum._
import art.{ArtNative_Ext, Empty}
import tc._

// This file was auto-generated.  Do not edit
abstract class OperatorInterface_tcp_opInterface_TestApi extends BridgeTestSuite[OperatorInterface_tcp_opInterface_Bridge](Arch.tcs_tcp_opInterface) {

  /** helper function to set the values of all input ports.
   * @param currentTemp payload for data port currentTemp
   */
  def put_concrete_inputs(currentTemp : TempControlAadl.Temperature): Unit = {
    put_currentTemp(currentTemp)
  }


  /** helper function to check OperatorInterface_tcp_opInterface's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param setPoint method that will be called with the payloads to be sent
   *        on the outgoing event data port 'setPoint'.
   */
  def check_concrete_output(setPoint: ISZ[TempControlAadl.Temperature] => B = setPointParam => {T}): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    var setPointValue: ISZ[TempControlAadl.Temperature] = ISZ()
    // TODO: event data port getter should return all of the events/payloads
    //       received on event data ports when queue sizes > 1 support is added
    //       to ART
    if(get_setPoint().nonEmpty) setPointValue = setPointValue :+ get_setPoint().get
    if(!setPoint(setPointValue)) {
      testFailures = testFailures :+ st"'setPoint' did not match expected: received ${setPointValue.size} events with the following payloads ${setPointValue}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // setter for in DataPort
  def put_currentTemp(value : TempControlAadl.Temperature): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.currentTemp_Id, TempControlAadl.Temperature_Payload(value))
  }

  // getter for out EventDataPort
  def get_setPoint(): Option[TempControlAadl.Temperature] = {
    val value: Option[TempControlAadl.Temperature] = get_setPoint_payload() match {
      case Some(TempControlAadl.Temperature_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port setPoint.  Expecting 'TempControlAadl.Temperature_Payload' but received ${v}")
      case _ => None[TempControlAadl.Temperature]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_setPoint_payload(): Option[TempControlAadl.Temperature_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.setPoint_Id).asInstanceOf[Option[TempControlAadl.Temperature_Payload]]
  }

}
