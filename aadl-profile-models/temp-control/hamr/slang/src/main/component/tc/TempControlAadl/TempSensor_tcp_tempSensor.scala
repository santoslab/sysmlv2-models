// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object TempSensor_tcp_tempSensor {

  def initialise(api: TempSensor_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.put_currentTemp(TempControlAadl.Temperature.example())
    api.put_tempChanged()
  }

  def timeTriggered(api: TempSensor_Operational_Api): Unit = {
    // example api usage


  }

  def activate(api: TempSensor_Operational_Api): Unit = { }

  def deactivate(api: TempSensor_Operational_Api): Unit = { }

  def finalise(api: TempSensor_Operational_Api): Unit = { }

  def recover(api: TempSensor_Operational_Api): Unit = { }
}
