package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle7Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle7Solution] */
class Riddle7Test {
  @Test fun solve() {
    Riddle7.solve(Observable.just(1, 2, 3, 1, 2, 4, 4, 5, 4))
        .test()
        .assertResult(1, 2, 3, 4, 5)
  }
}
