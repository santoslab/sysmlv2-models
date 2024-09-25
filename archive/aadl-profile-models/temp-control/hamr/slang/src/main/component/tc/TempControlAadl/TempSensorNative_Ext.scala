package tc.TempControlAadl

import org.sireum.F32
import tc.TempControlAadl.device.DeviceBridge

object TempSensorNative_Ext {
  var lastTemperature = Temperature(68f, TempUnit.Fahrenheit)
  var rand = new java.util.Random

  def currentTempGet(): Temperature = {
    if (DeviceBridge.ready) {
      return Temperature(DeviceBridge.getCurrentTemp(), TempUnit.Fahrenheit)
    } else {
      lastTemperature = if (rand.nextBoolean()) {
        val delta =
          F32((rand.nextGaussian() * 3).abs.min(2).toFloat *
            (if (FanNative_Ext.isOn) -1 else 1))
        lastTemperature(degrees = lastTemperature.degrees + delta)
      } else lastTemperature
      lastTemperature
    }
  }
}
