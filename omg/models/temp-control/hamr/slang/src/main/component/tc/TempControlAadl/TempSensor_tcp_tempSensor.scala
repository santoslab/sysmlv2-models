// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object TempSensor_tcp_tempSensor {

  def initialise(api: TempSensor_Initialization_Api): Unit = {
    api.put_ports_currentTemp(Temperature.example())
    api.put_ports_tempChanged()
  }

  def timeTriggered(api: TempSensor_Operational_Api): Unit = {
    val temp = TempSensorNative.currentTempGet()
    api.put_ports_currentTemp(temp)
    api.put_ports_tempChanged()
    val degree = Util.toFahrenheit(temp).degrees
    api.logInfo(s"Sensed temperature: $degree F")// example api usage


  }

  def activate(api: TempSensor_Operational_Api): Unit = { }

  def deactivate(api: TempSensor_Operational_Api): Unit = { }

  def finalise(api: TempSensor_Operational_Api): Unit = { }

  def recover(api: TempSensor_Operational_Api): Unit = { }
}

@ext object TempSensorNative {
  def currentTempGet(): Temperature = $
}