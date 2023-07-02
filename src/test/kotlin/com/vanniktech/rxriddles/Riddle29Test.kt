package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle29Solution
import io.reactivex.rxjava3.subjects.MaybeSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.atomic.AtomicReference

/** Solution [Riddle29Solution] */
class Riddle29Test {
  @Test fun onComplete() {
    val subject = MaybeSubject.create<Int>()
    val atomicError = AtomicReference<Throwable>()

    val o = Riddle29.solve(subject) { atomicError.set(it) }
        .test()
        .assertEmpty()

    subject.onComplete()
    assertThat(atomicError.get()).isNull()
    o.assertResult()
  }

  @Test fun onError() {
    val subject = MaybeSubject.create<Int>()
    val atomicError = AtomicReference<Throwable>()

    val o = Riddle29.solve(subject) { atomicError.set(it) }
        .test()
        .assertEmpty()

    val exception = RuntimeException("error")
    subject.onError(exception)
    assertThat(atomicError.get()).isEqualTo(exception)
    o.assertFailure(RuntimeException::class.java)
  }

  @Test fun onNext() {
    val subject = MaybeSubject.create<Int>()
    val atomicError = AtomicReference<Throwable>()

    val o = Riddle29.solve(subject) { atomicError.set(it) }
        .test()
        .assertEmpty()

    subject.onSuccess(5)
    assertThat(atomicError.get()).isNull()
    o.assertResult(5)
  }
}
