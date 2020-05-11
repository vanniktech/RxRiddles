package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle18Solution
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

/** Solution [Riddle18Solution] */
class Riddle18Test {
  @Test fun solve() {
    val first = PublishSubject.create<Int>()
    val second = PublishSubject.create<Int>()
    val o = Riddle18.solve(first, second)
        .test()
        .assertEmpty()

    first.onNext(1)
    second.onNext(2)
    o.assertValuesOnly(1)

    first.onNext(3)
    first.onNext(4)
    o.assertValuesOnly(1, 3, 4)

    second.onNext(3)
    second.onNext(4)
    second.onComplete()
    o.assertValuesOnly(1, 3, 4)

    first.onComplete()
    o.assertResult(1, 3, 4)
  }
}
