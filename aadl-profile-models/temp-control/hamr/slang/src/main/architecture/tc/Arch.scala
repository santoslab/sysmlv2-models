// #Sireum

package tc

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val tcs_tcp_tempSensor : tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge = {
    val currentTemp = Port[TempControlAadl.Temperature] (id = 0, name = "tcs_tcp_tempSensor_currentTemp", mode = DataOut)
    val tempChanged = Port[art.Empty] (id = 1, name = "tcs_tcp_tempSensor_tempChanged", mode = EventOut)

    tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge(
      id = 0,
      name = "tcs_tcp_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      tempChanged = tempChanged
    )
  }
  val tcs_tcp_tempControl : tc.TempControlAadl.TempControl_tcp_tempControl_Bridge = {
    val currentTemp = Port[TempControlAadl.Temperature] (id = 2, name = "tcs_tcp_tempControl_currentTemp", mode = DataIn)
    val tempChanged = Port[art.Empty] (id = 3, name = "tcs_tcp_tempControl_tempChanged", mode = EventIn)
    val fanCmd = Port[TempControlAadl.FanCmd] (id = 4, name = "tcs_tcp_tempControl_fanCmd", mode = EventOut)
    val fanAck = Port[TempControlAadl.FanAck] (id = 5, name = "tcs_tcp_tempControl_fanAck", mode = EventIn)
    val setPoint = Port[TempControlAadl.Temperature] (id = 6, name = "tcs_tcp_tempControl_setPoint", mode = EventIn)

    tc.TempControlAadl.TempControl_tcp_tempControl_Bridge(
      id = 1,
      name = "tcs_tcp_tempControl",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      tempChanged = tempChanged,
      fanCmd = fanCmd,
      fanAck = fanAck,
      setPoint = setPoint
    )
  }
  val tcs_tcp_fan : tc.TempControlAadl.Fan_tcp_fan_Bridge = {
    val fanCmd = Port[TempControlAadl.FanCmd] (id = 7, name = "tcs_tcp_fan_fanCmd", mode = EventIn)
    val fanAck = Port[TempControlAadl.FanAck] (id = 8, name = "tcs_tcp_fan_fanAck", mode = EventOut)

    tc.TempControlAadl.Fan_tcp_fan_Bridge(
      id = 2,
      name = "tcs_tcp_fan",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      fanCmd = fanCmd,
      fanAck = fanAck
    )
  }
  val tcs_tcp_opInterface : tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge = {
    val currentTemp = Port[TempControlAadl.Temperature] (id = 9, name = "tcs_tcp_opInterface_currentTemp", mode = DataIn)
    val setPoint = Port[TempControlAadl.Temperature] (id = 10, name = "tcs_tcp_opInterface_setPoint", mode = EventOut)

    tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge(
      id = 3,
      name = "tcs_tcp_opInterface",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      setPoint = setPoint
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = ISZ (tcs_tcp_tempSensor, tcs_tcp_tempControl, tcs_tcp_fan, tcs_tcp_opInterface),

      connections = ISZ ()
    )
  }
}
