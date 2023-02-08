package art

import org.sireum.S64._
import org.sireum.{B, F, String, T}

import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.{Executors, TimeUnit}
import scala.collection.mutable.{Map => MMap}

object ArtTimer_Ext {

  protected[art] val scheduledCallbacks: MMap[String, AtomicBoolean] = ArtNative_Ext.concMap()
  private val executor = Executors.newSingleThreadScheduledExecutor()

  def finalise(): Unit = {
    executor.shutdownNow()
    ArtNative.logInfo(Art.logTitle, "Finalized ArtTimer")
  }

  def cancel(id: String): Unit = {
    scheduledCallbacks.get(id) match {
      case Some(b) =>
        val userRequested = b.get()
        b.set(F)
        scheduledCallbacks.remove(id)
        if (userRequested) {
          ArtNative.logInfo(Art.logTitle, s"Callback cleared for $id")
        }
      case _ =>
    }
  }

  def scheduleTrait(id: String, replaceExisting: B, delay: Art.Time, callback: TimerCallback): Unit = {
    schedule(id, replaceExisting, delay, callback.callback _)
  }

  def schedule(id: String, replaceExisting: B, delay: Art.Time, callback: () => Unit): Unit = {
    if (scheduledCallbacks.get(id).nonEmpty) {
      if (!replaceExisting) {
        ArtNative.logInfo(Art.logTitle, s"Callback already scheduled for $id")
        return
      } else {
        cancel(id)
      }
    }

    if (delay < s64"0") {
      ArtNative.logInfo(Art.logTitle, s"Invalid delay time: ${delay}.  Value must be non-negative.")
      return
    }

    val shouldInvokeCallback = new AtomicBoolean(T)

    val task = new Runnable {
      override def run(): Unit = {
        if (shouldInvokeCallback.get()) {
          shouldInvokeCallback.set(F)
          cancel(id)

          callback()
        }
      }
    }

    scheduledCallbacks.put(id, shouldInvokeCallback)

    val adjusted = delay.toMP.toLong * ArtNative_Ext.slowdown.toMP.toLong
    executor.schedule(task, adjusted, TimeUnit.MILLISECONDS)

    ArtNative.logInfo(Art.logTitle, s"Callback scheduled for $id")
  }
}