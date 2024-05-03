// #Sireum

package tc.TempControlAadl

import org.sireum._

object Util {
  val minTemp: F32 = 70f
  val maxTemp: F32 = 100f

  val lowTemp: F32 = 80f
  val highTemp: F32 = 90f

  @pure def toFahrenheit(value: Temperature): Temperature = {
    if (value.unit == TempUnit.Fahrenheit) {
      return value
    } else if (value.unit == TempUnit.Celsius) {
      return Temperature(value.degrees * 9f / 5f + 32f, TempUnit.Fahrenheit)
    } else {
      return Temperature(value.degrees * 9f / 5f - 459.67f, TempUnit.Fahrenheit)
    }
  }
}
