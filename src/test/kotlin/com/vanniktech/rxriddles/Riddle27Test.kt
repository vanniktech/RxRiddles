package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle27Solution
import io.reactivex.rxjava3.subjects.PublishSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/** Solution [Riddle27Solution] */
class Riddle27Test {
  @Test fun solve() {
    val subject = PublishSubject.create<Long>()
    val values = mutableListOf<Long>()

    val o = Riddle27.solve(subject) { values.add(it) }
        .test()
        .assertEmpty()

    subject.onNext(2)
    assertThat(values).containsExactly(2)
    o.assertValuesOnly(2)

    subject.onNext(6)
    assertThat(values).containsExactly(2, 6)
    o.assertValuesOnly(2, 6)

    subject.onComplete()
    assertThat(values).containsExactly(2, 6)
    o.assertResult(2, 6)
  }
}
