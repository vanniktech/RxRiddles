package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle11Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS

/** Solution [Riddle11Solution] */
class Riddle11Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val source = Observable.fromIterable(listOf(50L, 200L, 250L, 400L))
        .flatMapSingle { Single.timer(it, MILLISECONDS, rxRule).map {  } }

    val o = Riddle11.solve(source)
        .test()
        .assertEmpty()

    rxRule.advanceTimeBy(50, MILLISECONDS)
    o.assertValuesOnly(Unit) // Handle the first one.

    rxRule.advanceTimeBy(200, MILLISECONDS)
    o.assertValuesOnly(Unit) // Don't handle any others.

    rxRule.advanceTimeBy(150, MILLISECONDS)
    o.assertResult(Unit, Unit) // Now process the next one.
  }
}
