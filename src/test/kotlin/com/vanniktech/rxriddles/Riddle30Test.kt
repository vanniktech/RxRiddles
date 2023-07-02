package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle30Solution
import io.reactivex.rxjava3.subjects.SingleSubject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle30Solution] */
class Riddle30Test {
  @Test fun solve() {
    val subject = SingleSubject.create<Int>()
    val counter = AtomicInteger()

    val single = Riddle30.solve(subject) { counter.incrementAndGet() }

    assertThat(counter.get()).isEqualTo(0)
    val o = single.test()
    assertThat(counter.get()).isEqualTo(1)

    subject.onSuccess(5)
    o.assertResult(5)
    assertThat(counter.get()).isEqualTo(1)
  }
}
