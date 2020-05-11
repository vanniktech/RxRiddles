package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle101Solution
import com.vanniktech.rxriddles.tools.RxRule
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.SECONDS

/** Solution [Riddle101Solution] */
class Riddle101Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val o = Riddle101.solve(60)
        .test()

    rxRule.triggerActions()
    o.assertValuesOnly(60)

    rxRule.advanceTimeBy(1, SECONDS)
    o.assertValuesOnly(60, 59)

    rxRule.advanceTimeBy(29, SECONDS)
    o.assertValueSequence((30L..60L).reversed())

    rxRule.advanceTimeBy(30, SECONDS)
    o.assertValueSequence((0L..60L).reversed())
        .assertNoErrors()
        .assertComplete()
  }
}
