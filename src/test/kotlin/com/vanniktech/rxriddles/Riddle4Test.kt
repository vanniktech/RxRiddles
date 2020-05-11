package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle4Solution
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

/** Solution [Riddle4Solution] */
class Riddle4Test {
  @Test fun solve() {
    val subject = PublishSubject.create<Unit>()

    val o = Riddle4.solve(subject)
        .test()
        .assertValuesOnly(false)

    subject.onNext(Unit)
    o.assertValuesOnly(false, true)

    subject.onNext(Unit)
    o.assertValuesOnly(false, true, false)

    subject.onNext(Unit)
    o.assertValuesOnly(false, true, false, true)
  }
}
