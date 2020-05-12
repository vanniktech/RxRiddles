package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle20Solution
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

/** Solution [Riddle20Solution] */
class Riddle20Test {
  @Test fun solve() {
    val first = PublishSubject.create<Int>()
    val second = PublishSubject.create<Int>()
    val o = Riddle20.solve(first, second)
        .test()
        .assertEmpty()

    first.onNext(1)
    o.assertValuesOnly(1)

    second.onNext(2)
    second.onNext(3)
    o.assertValuesOnly(1, 2, 3)

    first.onNext(5)
    first.onComplete()
    o.assertValuesOnly(1, 2, 3, 5)

    second.onNext(6)
    second.onComplete()
    o.assertResult(1, 2, 3, 5, 6)
  }
}
