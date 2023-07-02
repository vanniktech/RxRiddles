package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle26Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle26Solution] */
class Riddle26Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val doOnSubscribe = AtomicInteger()

    val source = Observable.just(0L, 1L, 2L)
        .flatMapSingle { number -> Single.timer(number * 300L, MILLISECONDS, rxRule).map { number } }
        .doOnSubscribe { doOnSubscribe.incrementAndGet() }

    val o = Riddle26.solve(source)
        .test()
        .assertEmpty()

    assertThat(doOnSubscribe.get()).isEqualTo(1) // Needs to subscribe immediately.

    rxRule.advanceTimeBy(200, MILLISECONDS)
    o.assertEmpty()

    rxRule.advanceTimeBy(100, MILLISECONDS)
    o.assertValuesOnly(0)

    rxRule.advanceTimeBy(300, MILLISECONDS)
    o.assertValuesOnly(0, 1)

    rxRule.advanceTimeBy(300, MILLISECONDS)
    o.assertResult(0, 1, 2)
  }
}
