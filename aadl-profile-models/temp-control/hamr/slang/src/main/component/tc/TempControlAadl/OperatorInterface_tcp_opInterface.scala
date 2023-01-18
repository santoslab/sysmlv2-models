// #Sireum

package tc.TempControlAadl

import org.sireum._
import tc._

// This file will not be overwritten so is safe to edit
object OperatorInterface_tcp_opInterface {

  def initialise(api: OperatorInterface_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.put_setPoint(TempControlAadl.Temperature.example())
  }

  def timeTriggered(api: OperatorInterface_Operational_Api): Unit = {
    // example api usage

    val apiUsage_currentTemp: Option[TempControlAadl.Temperature] = api.get_currentTemp()
    api.logInfo(s"Received on currentTemp: ${apiUsage_currentTemp}")
  }

  def activate(api: OperatorInterface_Operational_Api): Unit = { }

  def deactivate(api: OperatorInterface_Operational_Api): Unit = { }

  def finalise(api: OperatorInterface_Operational_Api): Unit = { }

  def recover(api: OperatorInterface_Operational_Api): Unit = { }
}
