package tc

import org.sireum._
import art.Art
import art.scheduling.static.Schedule.DScheduleSpec

// This file was auto-generated.  Do not edit

object ScheduleProvider {

  def getRoundRobinOrder(): ISZ[Art.BridgeId] = {
    return Schedulers.roundRobinSchedule
  }

  def getStaticSchedule(): DScheduleSpec = {
    return Schedulers.staticSchedule
  }
}
