package tc.TempControlAadl.device

import tc.TempControlAadl.device.FirmataUtil.PinMode
import tc.TempControlAadl.{FanAck, FanCmd, Util}
import org.sireum._

object DeviceBridge {
  val port: String = "/dev/cu.usbmodem14301"
  val pwmPort: Z = 9
  val ledPin: Z = 13
  val analog0Pin: Z = 14

  val minTempZ: Z = Z(Util.minTemp.value.toInt)
  val maxTempZ: Z = Z(Util.maxTemp.value.toInt)

  def init(): Unit = {
    UnoBoard.init(port)
  }

  def ready: B = {
    init()
    return UnoBoard.ready
  }

  def getCurrentTemp(): F32 = {
    init()

    // potentiometer connection is flaky so get average sampled reading
    var accum: Z = 0
    val numReads: Z = 100
    for (i <- 0 to numReads) {
      accum = accum + UnoBoard.analogRead(analog0Pin, PinMode.ANALOG)
    }

    // scale value so that it's within led range
    val ledScaled = map(accum / numReads, 0, 1033, 0, 255)

    // use pwm to display room temp: brighter == hotter
    UnoBoard.analogWrite(pwmPort, PinMode.PWM, ledScaled)

    // scale value so that it's within the absolute min/max of the sensor
    val tempScaled = map(ledScaled, 0, 255, minTempZ, maxTempZ)
    return org.sireum.F32(tempScaled.toInt * 1.0f)
  }

  def sendFanCmd(cmd: FanCmd.Type): FanAck.Type = {
    init()

    cmd match {
      case FanCmd.On =>
        UnoBoard.analogWrite(ledPin, PinMode.OUTPUT, 255)
      case FanCmd.Off =>
        UnoBoard.analogWrite(ledPin, PinMode.OUTPUT, 0)
    }

    return FanAck.Ok
  }

  def map(x: Z, in_min: Z, in_max: Z, out_min: Z, out_max: Z): Z = {
    return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min
  }
}
