package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle3Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle3Solution] */
class Riddle3Test {
  @Test fun solve() {
    Riddle3.solve(Observable.range(0, 10))
        .test()
        .assertResult(0, 2, 4, 6, 8)
  }
}
