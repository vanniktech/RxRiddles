package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle16Solution
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.SingleSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/** Solution [Riddle16Solution] */
class Riddle16Test {
  @Test fun solve() {
    val subject = PublishSubject.create<String>()

    val inner1 = SingleSubject.create<Int>()
    val inner2 = SingleSubject.create<Int>()

    val o = Riddle16.solve(subject) {
      if (it == "1") {
        inner1
      } else {
        inner2
      }
    }
        .test()
        .assertEmpty()

    subject.onNext("1")
    o.assertEmpty()
    assertThat(inner1.hasObservers()).isTrue()

    subject.onNext("2")
    assertThat(inner1.hasObservers()).isFalse()
    assertThat(inner2.hasObservers()).isTrue()

    inner2.onError(RuntimeException())
    assertThat(subject.hasObservers()).isFalse()
    o.assertFailure(RuntimeException::class.java)
  }
}
