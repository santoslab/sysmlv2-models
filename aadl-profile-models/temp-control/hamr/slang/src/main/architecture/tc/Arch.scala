// #Sireum

package tc

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val tcs_tcp_tempSensor : tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = 0, name = "tcs_tcp_tempSensor_ports_currentTemp", mode = DataOut)
    val ports_tempChanged = Port[art.Empty] (id = 1, name = "tcs_tcp_tempSensor_ports_tempChanged", mode = EventOut)

    tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge(
      id = 0,
      name = "tcs_tcp_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_currentTemp = ports_currentTemp,
      ports_tempChanged = ports_tempChanged
    )
  }
  val tcs_tcp_tempControl : tc.TempControlAadl.TempControl_tcp_tempControl_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = 2, name = "tcs_tcp_tempControl_ports_currentTemp", mode = DataIn)
    val ports_tempChanged = Port[art.Empty] (id = 3, name = "tcs_tcp_tempControl_ports_tempChanged", mode = EventIn)
    val ports_fanCmd = Port[TempControlAadl.FanCmd.Type] (id = 4, name = "tcs_tcp_tempControl_ports_fanCmd", mode = EventOut)
    val ports_fanAck = Port[TempControlAadl.FanAck.Type] (id = 5, name = "tcs_tcp_tempControl_ports_fanAck", mode = EventIn)
    val ports_setPoint = Port[TempControlAadl.SetPoint] (id = 6, name = "tcs_tcp_tempControl_ports_setPoint", mode = EventIn)

    tc.TempControlAadl.TempControl_tcp_tempControl_Bridge(
      id = 1,
      name = "tcs_tcp_tempControl",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      ports_currentTemp = ports_currentTemp,
      ports_tempChanged = ports_tempChanged,
      ports_fanCmd = ports_fanCmd,
      ports_fanAck = ports_fanAck,
      ports_setPoint = ports_setPoint
    )
  }
  val tcs_tcp_fan : tc.TempControlAadl.Fan_tcp_fan_Bridge = {
    val ports_fanCmd = Port[TempControlAadl.FanCmd.Type] (id = 7, name = "tcs_tcp_fan_ports_fanCmd", mode = EventIn)
    val ports_fanAck = Port[TempControlAadl.FanAck.Type] (id = 8, name = "tcs_tcp_fan_ports_fanAck", mode = EventOut)

    tc.TempControlAadl.Fan_tcp_fan_Bridge(
      id = 2,
      name = "tcs_tcp_fan",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      ports_fanCmd = ports_fanCmd,
      ports_fanAck = ports_fanAck
    )
  }
  val tcs_tcp_opInterface : tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = 9, name = "tcs_tcp_opInterface_ports_currentTemp", mode = DataIn)
    val ports_setPoint = Port[TempControlAadl.SetPoint] (id = 10, name = "tcs_tcp_opInterface_ports_setPoint", mode = EventOut)

    tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge(
      id = 3,
      name = "tcs_tcp_opInterface",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_currentTemp = ports_currentTemp,
      ports_setPoint = ports_setPoint
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = ISZ (tcs_tcp_tempSensor, tcs_tcp_tempControl, tcs_tcp_fan, tcs_tcp_opInterface),

      connections = ISZ (Connection(from = tcs_tcp_tempSensor.ports_currentTemp, to = tcs_tcp_tempControl.ports_currentTemp),
                         Connection(from = tcs_tcp_tempSensor.ports_currentTemp, to = tcs_tcp_opInterface.ports_currentTemp),
                         Connection(from = tcs_tcp_tempSensor.ports_tempChanged, to = tcs_tcp_tempControl.ports_tempChanged),
                         Connection(from = tcs_tcp_tempControl.ports_fanCmd, to = tcs_tcp_fan.ports_fanCmd),
                         Connection(from = tcs_tcp_fan.ports_fanAck, to = tcs_tcp_tempControl.ports_fanAck),
                         Connection(from = tcs_tcp_opInterface.ports_setPoint, to = tcs_tcp_tempControl.ports_setPoint))
    )
  }
}
