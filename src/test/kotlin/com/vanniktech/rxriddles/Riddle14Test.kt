package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle14Solution
import io.reactivex.rxjava3.core.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle14Solution] */
class Riddle14Test {
  @Test fun success() {
    Riddle14.solve(Single.just(Unit))
        .test()
        .assertResult(Unit)
  }

  @Test fun retriesOnlyThreeTimes() {
    val subscribeCounter = AtomicInteger(0)
    Riddle14.solve(Single.fromCallable {
      subscribeCounter.getAndIncrement()
      throw UnsupportedOperationException()
    })
        .test()
        .assertFailure(UnsupportedOperationException::class.java)

    assertThat(subscribeCounter.get()).isEqualTo(3)
  }

  @Test fun valueAtSecond() {
    val subscribeCounter = AtomicInteger(0)
    Riddle14.solve(Single.fromCallable {
      if (subscribeCounter.getAndIncrement() == 1) {
        Unit
      } else {
        throw UnsupportedOperationException()
      }
    })
        .test()
        .assertResult(Unit)

    assertThat(subscribeCounter.get()).isEqualTo(2)
  }

  @Test fun stopsAtIllegalArgumentException() {
    val subscribeCounter = AtomicInteger(0)
    Riddle14.solve(Single.fromCallable {
      if (subscribeCounter.getAndIncrement() == 1) {
        throw IllegalArgumentException()
      } else {
        throw UnsupportedOperationException()
      }
    })
        .test()
        .assertFailure(IllegalArgumentException::class.java)

    assertThat(subscribeCounter.get()).isEqualTo(2)
  }
}
