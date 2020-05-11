package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle31Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle31Solution] */
class Riddle31Test {
  @Test fun solve() {
    val subscribeCall = AtomicInteger()

    val o = Observable.create<Int> {
      when (subscribeCall.getAndIncrement()) {
        0 -> listOf(1, 2, 3).forEach(it::onNext)
        1 -> listOf(6, 7, 8).forEach(it::onNext)
        2 -> listOf(15, 16).forEach(it::onNext)
      }

      it.onComplete()
    }

    Riddle31.solve(o)
        .test()
        .assertResult(1, 2, 3, 6, 7, 8, 15, 16)
  }
}
