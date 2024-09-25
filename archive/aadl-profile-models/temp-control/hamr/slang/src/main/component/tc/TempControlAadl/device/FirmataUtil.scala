// #Sireum
package tc.TempControlAadl.device

import org.sireum._

object FirmataUtil {
  @enum object PinMode {
    "INPUT" //Digital pin in input mode
    "OUTPUT" // Digital pin in output mode
    "ANALOG" // Analog pin in analog input mode
    "PWM" // Digital pin in PWM output mode
    "SERVO"
  }
}
