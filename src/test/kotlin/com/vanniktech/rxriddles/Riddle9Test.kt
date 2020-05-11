package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle9Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit.SECONDS

/** Solution [Riddle9Solution] */
class Riddle9Test {
  @get:Rule val rxRule = RxRule()

  @Test fun solve() {
    val trigger = PublishSubject.create<Unit>()
    val main = Observable.interval(1, SECONDS).map { Unit }

    val o = Riddle9.solve(main, trigger)
        .test()
        .assertEmpty()

    rxRule.advanceTimeBy(1, SECONDS)
    o.assertValueCount(1)

    rxRule.advanceTimeBy(15, SECONDS)
    o.assertValueCount(16)

    trigger.onNext(Unit)

    rxRule.advanceTimeBy(15, SECONDS)
    o.assertValueCount(16)
  }
}
