package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle24Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle24Solution] */
class Riddle24Test {
  @Test fun solve() {
    Riddle24.solve(Observable.just(Unit, Unit))
        .test()
        .assertResult(2L)
  }
}
