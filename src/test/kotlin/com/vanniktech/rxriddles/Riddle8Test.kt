package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle8Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle8Solution] */
class Riddle8Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val counter = AtomicInteger()

    val source = Observable.just(Unit)
        .doOnSubscribe { counter.incrementAndGet() }
        .doOnEach { counter.incrementAndGet() }
        .doOnError { counter.incrementAndGet() }
        .doOnComplete { counter.incrementAndGet() }

    val o = Riddle8.solve(source)
        .test()
        .assertEmpty()

    assertThat(counter.get()).isEqualTo(0) // We don't want to do anything.

    rxRule.advanceTimeBy(100, MILLISECONDS)
    o.assertEmpty()
    assertThat(counter.get()).isEqualTo(0)

    rxRule.advanceTimeBy(200, MILLISECONDS)
    o.assertResult(Unit)
    assertThat(counter.get()).isEqualTo(4)
  }
}
