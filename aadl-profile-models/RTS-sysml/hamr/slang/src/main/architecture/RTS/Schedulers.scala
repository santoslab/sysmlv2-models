// #Sireum
package RTS

import org.sireum._
import art.Art
import art.scheduling.legacy.Legacy
import art.scheduling.roundrobin.RoundRobin
import art.scheduling.static.Schedule.{DSchedule, DScheduleSpec, Slot}
import art.scheduling.static.StaticScheduler

// This file was auto-generated.  Do not edit

@datatype class ProcessorTimingProperties(val clockPeriod: Option[Z],
                                          val framePeriod: Option[Z],
                                          val maxDomain: Option[Z],
                                          val slotTime: Option[Z])

@datatype class ThreadTimingProperties(val domain: Option[Z],
                                       val computeExecutionTime: Option[(Z, Z)])

object Schedulers {


  val rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_instrumentationMock_instrumentationMockThread_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_eventControlMock_eventControlMockThread_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  val rts_actuatorsMock_actuatorsMockThread_timingProperties: ThreadTimingProperties = ThreadTimingProperties(
    computeExecutionTime = None(),
    domain = None())

  // roundRobinSchedule represents the component dispatch order
  val roundRobinSchedule: ISZ[art.Bridge] = Arch.ad.components

  val framePeriod: Z = 1000
  val numComponents: Z = Arch.ad.components.size
  val maxExecutionTime: Z = numComponents / framePeriod

  // staticSchedule represents the component dispatch order
  val staticSchedule: DScheduleSpec = DScheduleSpec(0, 0, DSchedule(ISZ(
    Slot(Arch.rts_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.id, maxExecutionTime),
    Slot(Arch.rts_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.id, maxExecutionTime),
    Slot(Arch.rts_instrumentationMock_instrumentationMockThread.id, maxExecutionTime),
    Slot(Arch.rts_eventControlMock_eventControlMockThread.id, maxExecutionTime),
    Slot(Arch.rts_actuatorsMock_actuatorsMockThread.id, maxExecutionTime)
  )))


  def getRoundRobinScheduler(schedule: Option[ISZ[art.Bridge]]): RoundRobin = {
    if(roundRobinSchedule.isEmpty) {} // line needed for transpiler; do not remove
    schedule match {
      case Some(s) => return RoundRobin(s)
      case _ => return RoundRobin(ScheduleProviderI.getRoundRobinOrder())
    }
  }

  def getStaticScheduler(schedule: Option[DScheduleSpec]): StaticScheduler = {
    if(staticSchedule.schedule.slots.isEmpty) {} // line needed for transpiler; do not remove
    schedule match {
      case Some(s) => return StaticScheduler(Arch.ad.components, s)
      case _ => return StaticScheduler(Arch.ad.components, ScheduleProviderI.getStaticSchedule())
    }
  }

  def getLegacyScheduler(): Legacy = {
    return Legacy(Arch.ad.components)
  }
}

@ext(name = "ScheduleProvider") object ScheduleProviderI {
  def getRoundRobinOrder(): ISZ[art.Bridge] = $
  def getStaticSchedule(): DScheduleSpec = $
}