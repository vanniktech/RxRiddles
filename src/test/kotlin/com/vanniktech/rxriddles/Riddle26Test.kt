package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle26Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.Observable
import io.reactivex.Single
import org.assertj.core.api.Java6Assertions
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle26Solution] */
class Riddle26Test {
  @get:Rule val rxRule = RxRule()

    @Test
    fun solve() {
    val c = AtomicInteger()
        
    val source = Observable.just(0L, 1L, 2L)
         .flatMapSingle { number -> Single.timer(number * 300L, MILLISECONDS, rxRule).map { number } }
         .doOnSubscribe { c.incrementAndGet() }

    val o = Riddle26.solve(source)
        .test()
        .assertEmpty()

        Java6Assertions.assertThat(c.get()).isEqualTo(1) // Prevents delaying subscription

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
