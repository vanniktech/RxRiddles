package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle6Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle6Solution] */
class Riddle6Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val subscribeCounter = AtomicInteger()

    val first = Single.timer(5, SECONDS, rxRule)
        .map { 10 }
        .doOnSubscribe { subscribeCounter.incrementAndGet() }

    val second = Single.just(5)
        .doOnSubscribe { subscribeCounter.incrementAndGet() }

    val o = Riddle6.solve(first, second)
        .test()
        .assertEmpty()

    assertThat(subscribeCounter.get()).isEqualTo(2) // We want to subscribe immediately.

    rxRule.advanceTimeBy(4, SECONDS)
    o.assertEmpty()

    rxRule.advanceTimeBy(1, SECONDS)
    o.assertResult(10 to 5)
  }
}
