package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle102Solution
import com.vanniktech.rxriddles.tools.awaitTerminalEvent
import io.reactivex.rxjava3.core.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.MILLISECONDS

/** Solution [Riddle102Solution] */
class Riddle102Test {

  @Test fun solve() {
    // Each single will count down and wait for the other, before emitting.
    // Timeout means the other Single hasn't been subscribed to
    val subscribeLatch = CountDownLatch(2)

    val testThread = Thread.currentThread()

    fun registerSubscription(which: String) {
      assertThat(Thread.currentThread())
          .withFailMessage("The $which observable wasn't executing on a background thread")
          .isNotEqualTo(testThread)
      subscribeLatch.countDown()

      val otherSubscriptionTriggered = subscribeLatch.await(200, MILLISECONDS)

      assertThat(otherSubscriptionTriggered)
          .withFailMessage("The observables weren't executing in parallel")
          .isTrue()
    }

    val first = Single.fromCallable { 10 }
        .doOnSubscribe { registerSubscription("first") }

    val second = Single.fromCallable { 5 }
        .doOnSubscribe { registerSubscription("second") }

    val o = Riddle102.solve(first, second)
        .test()

    o.awaitTerminalEvent()

    o.assertResult(10 to 5)
  }
}
