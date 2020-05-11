package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle25Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle25Solution] */
class Riddle25Test {
  @Test fun empty() {
    Riddle25.solve(Observable.empty<Int>())
        .test()
        .assertResult(5)
  }

  @Test fun nonEmpty() {
    Riddle25.solve(Observable.just(1, 3))
        .test()
        .assertResult(1, 3)
  }
}
