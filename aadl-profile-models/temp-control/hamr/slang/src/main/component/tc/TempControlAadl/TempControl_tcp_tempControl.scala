// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object TempControl_tcp_tempControl {

  var setPoint: SetPoint_i =
    SetPoint_i(
      Temperature(Util.minTemp, TempUnit.Fahrenheit),
      Temperature(Util.maxTemp, TempUnit.Fahrenheit))

  def initialise(api: TempControl_Initialization_Api): Unit = {
    setPoint = SetPoint_i(
      Temperature(Util.lowTemp, TempUnit.Fahrenheit),
      Temperature(Util.highTemp, TempUnit.Fahrenheit))
  }

  def handle_ports_tempChanged(api: TempControl_Operational_Api): Unit = {
    val tempInF = Util.toFahrenheit(api.get_ports_currentTemp().get)
    val setPointLowInF = Util.toFahrenheit(setPoint.low)
    val setPointHighInF = Util.toFahrenheit(setPoint.high)
    val cmdOpt: Option[FanCmd.Type] =
      if (tempInF.degrees > setPointHighInF.degrees) Some(FanCmd.On)
      else if (tempInF.degrees < setPointLowInF.degrees) Some(FanCmd.Off)
      else None[FanCmd.Type]()
    cmdOpt match {
      case Some(cmd) =>
        api.put_ports_fanCmd(cmd)
        api.logInfo(s"Sent fan command: $cmd")
      case _ =>
        api.logInfo(s"Temperature ok: ${tempInF.degrees} F")
    }
  }

  def handle_ports_fanAck(api: TempControl_Operational_Api, value : TempControlAadl.FanAck.Type): Unit = {
    api.logInfo("example handle_fanAck implementation")
    api.logInfo(s"received ${value}")
  }

  def handle_ports_setPoint(api: TempControl_Operational_Api, value : TempControlAadl.Temperature): Unit = {
    api.logInfo("example handle_setPoint implementation")
    api.logInfo(s"received ${value}")
  }

  def activate(api: TempControl_Operational_Api): Unit = { }

  def deactivate(api: TempControl_Operational_Api): Unit = { }

  def finalise(api: TempControl_Operational_Api): Unit = { }

  def recover(api: TempControl_Operational_Api): Unit = { }
}
