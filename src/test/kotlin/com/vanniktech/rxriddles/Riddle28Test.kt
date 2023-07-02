package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle28Solution
import io.reactivex.rxjava3.subjects.CompletableSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle28Solution] */
class Riddle28Test {
  @Test fun onComplete() {
    val subject = CompletableSubject.create()
    val atomicInteger = AtomicInteger()

    val o = Riddle28.solve(subject) { atomicInteger.incrementAndGet() }
        .test()
        .assertEmpty()

    subject.onComplete()
    assertThat(atomicInteger.get()).isEqualTo(1)
    o.assertResult()
  }

  @Test fun onError() {
    val subject = CompletableSubject.create()
    val atomicInteger = AtomicInteger()

    val o = Riddle28.solve(subject) { atomicInteger.incrementAndGet() }
        .test()
        .assertEmpty()

    subject.onError(RuntimeException("error"))
    assertThat(atomicInteger.get()).isEqualTo(0)
    o.assertFailure(RuntimeException::class.java)
  }
}
