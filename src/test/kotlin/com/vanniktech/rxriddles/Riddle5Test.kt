package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle5Solution
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.junit.Test

/** Solution [Riddle5Solution] */
class Riddle5Test {
  @Test fun solve() {
    val first = BehaviorSubject.createDefault(0)
    val second = BehaviorSubject.createDefault(0)

    val o = Riddle5.solve(first, second)
        .test()
        .assertValuesOnly(0)

    first.onNext(5)
    o.assertValuesOnly(0, 5)

    second.onNext(6)
    o.assertValuesOnly(0, 5, 11)

    first.onNext(-6)
    o.assertValuesOnly(0, 5, 11, 0)
  }
}
