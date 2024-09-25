package tc.TempControlAadl

import tc.TempControlAadl.device.DeviceBridge

object FanNative_Ext {

  val errorRate = 35
  val rand = new java.util.Random
  var isOn: Boolean = false

  def fanCmdActuate(cmd: FanCmd.Type): FanAck.Type = {
    if (DeviceBridge.ready) {
      return DeviceBridge.sendFanCmd(cmd)
    } else {
      val r = if (rand.nextInt(100) < 100 - errorRate) {
        isOn = cmd == FanCmd.On
        FanAck.Ok
      } else FanAck.Error
      return r
    }
  }
}
