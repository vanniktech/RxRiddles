package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle15Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle15Solution] */
class Riddle15Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val subscribeCounter = AtomicInteger()

    val first = Observable.timer(1, SECONDS)
        .doOnSubscribe { subscribeCounter.incrementAndGet() }
        .map { 1 }

    val second = Observable.just(5)
        .doOnSubscribe { subscribeCounter.incrementAndGet() }

    val o = Riddle15.solve(first, second)
        .test()
        .assertEmpty()

    assertThat(subscribeCounter.get()).isEqualTo(2) // We want to subscribe immediately.

    rxRule.advanceTimeBy(1, SECONDS)
    o.assertResult(1, 5)
  }
}
