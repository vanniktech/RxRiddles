package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle100Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS

/** Solution [Riddle100Solution] */
class Riddle100Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val source = Observable.fromIterable(listOf(0L, 200L, 400L, 700L, 800L))
        .flatMapSingle { Single.timer(it, MILLISECONDS, rxRule).map {  } }

    val o = Riddle100.solve(source)
        .test()
        .assertEmpty()

    rxRule.advanceTimeBy(100, MILLISECONDS)
    o.assertEmpty()

    rxRule.advanceTimeBy(200, MILLISECONDS)
    o.assertValuesOnly(Unit)

    rxRule.advanceTimeBy(300, MILLISECONDS)
    o.assertValuesOnly(Unit) // 300 - 600 segment does not contain any double click.

    rxRule.advanceTimeBy(300, MILLISECONDS)
    o.assertResult(Unit, Unit) // 600 - 900 does contain one.
  }
}
