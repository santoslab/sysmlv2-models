package RTS.Actuators

import org.sireum._
import art.{ArtNative_Ext, Empty}
import RTS._

// This file was auto-generated.  Do not edit
abstract class ActuatorsMockThread_actuatorsMock_actuatorsMockThread_TestApi extends BridgeTestSuite[ActuatorsMockThread_actuatorsMock_actuatorsMockThread_Bridge](Arch.rts_actuatorsMock_actuatorsMockThread) {

  /** helper function to set the values of all input ports.
   * @param ports_tempPressureActuate payload for data port ports_tempPressureActuate
   * @param ports_saturationActuate payload for data port ports_saturationActuate
   */
  def put_concrete_inputs(ports_tempPressureActuate : Base_Types.Boolean,
                          ports_saturationActuate : Base_Types.Boolean): Unit = {
    put_ports_tempPressureActuate(ports_tempPressureActuate)
    put_ports_saturationActuate(ports_saturationActuate)
  }


  // setter for in DataPort
  def put_ports_tempPressureActuate(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_tempPressureActuate_Id, Base_Types.Boolean_Payload(value))
  }

  // setter for in DataPort
  def put_ports_saturationActuate(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ports_saturationActuate_Id, Base_Types.Boolean_Payload(value))
  }

}
