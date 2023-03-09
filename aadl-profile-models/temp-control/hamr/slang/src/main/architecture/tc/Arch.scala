// #Sireum

package tc

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._
import art.Art.BridgeId._
import art.Art.PortId._

// This file was auto-generated.  Do not edit

object Arch {
  val tcs_tcp_tempSensor : tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = portId"0", name = "tcs_tcp_tempSensor_ports_currentTemp", mode = DataOut)
    val ports_tempChanged = Port[art.Empty] (id = portId"1", name = "tcs_tcp_tempSensor_ports_tempChanged", mode = EventOut)

    tc.TempControlAadl.TempSensor_tcp_tempSensor_Bridge(
      id = bridgeId"0",
      name = "tcs_tcp_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_currentTemp = ports_currentTemp,
      ports_tempChanged = ports_tempChanged
    )
  }
  val tcs_tcp_tempControl : tc.TempControlAadl.TempControl_tcp_tempControl_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = portId"2", name = "tcs_tcp_tempControl_ports_currentTemp", mode = DataIn)
    val ports_tempChanged = Port[art.Empty] (id = portId"3", name = "tcs_tcp_tempControl_ports_tempChanged", mode = EventIn)
    val ports_fanCmd = Port[TempControlAadl.FanCmd.Type] (id = portId"4", name = "tcs_tcp_tempControl_ports_fanCmd", mode = EventOut)
    val ports_fanAck = Port[TempControlAadl.FanAck.Type] (id = portId"5", name = "tcs_tcp_tempControl_ports_fanAck", mode = EventIn)
    val ports_setPoint = Port[TempControlAadl.SetPoint] (id = portId"6", name = "tcs_tcp_tempControl_ports_setPoint", mode = EventIn)

    tc.TempControlAadl.TempControl_tcp_tempControl_Bridge(
      id = bridgeId"1",
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
    val ports_fanCmd = Port[TempControlAadl.FanCmd.Type] (id = portId"7", name = "tcs_tcp_fan_ports_fanCmd", mode = EventIn)
    val ports_fanAck = Port[TempControlAadl.FanAck.Type] (id = portId"8", name = "tcs_tcp_fan_ports_fanAck", mode = EventOut)

    tc.TempControlAadl.Fan_tcp_fan_Bridge(
      id = bridgeId"2",
      name = "tcs_tcp_fan",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      ports_fanCmd = ports_fanCmd,
      ports_fanAck = ports_fanAck
    )
  }
  val tcs_tcp_opInterface : tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge = {
    val ports_currentTemp = Port[TempControlAadl.Temperature] (id = portId"9", name = "tcs_tcp_opInterface_ports_currentTemp", mode = DataIn)
    val ports_setPoint = Port[TempControlAadl.SetPoint] (id = portId"10", name = "tcs_tcp_opInterface_ports_setPoint", mode = EventOut)

    tc.TempControlAadl.OperatorInterface_tcp_opInterface_Bridge(
      id = bridgeId"3",
      name = "tcs_tcp_opInterface",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      ports_currentTemp = ports_currentTemp,
      ports_setPoint = ports_setPoint
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = IS[Art.BridgeId, Bridge] (tcs_tcp_tempSensor, tcs_tcp_tempControl, tcs_tcp_fan, tcs_tcp_opInterface),

      connections = IS[Art.ConnectionId, UConnection] (Connection(from = tcs_tcp_tempSensor.ports_currentTemp, to = tcs_tcp_tempControl.ports_currentTemp),
                                                       Connection(from = tcs_tcp_tempSensor.ports_currentTemp, to = tcs_tcp_opInterface.ports_currentTemp),
                                                       Connection(from = tcs_tcp_tempSensor.ports_tempChanged, to = tcs_tcp_tempControl.ports_tempChanged),
                                                       Connection(from = tcs_tcp_tempControl.ports_fanCmd, to = tcs_tcp_fan.ports_fanCmd),
                                                       Connection(from = tcs_tcp_fan.ports_fanAck, to = tcs_tcp_tempControl.ports_fanAck),
                                                       Connection(from = tcs_tcp_opInterface.ports_setPoint, to = tcs_tcp_tempControl.ports_setPoint))
    )
  }
}
