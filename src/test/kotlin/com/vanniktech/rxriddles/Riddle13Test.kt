package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle13Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle13Solution] */
class Riddle13Test {
  @Test fun solve() {
    Riddle13.solve(Observable.just(1, 2, 1, 1, 4, 4, 4, 5, 4))
        .test()
        .assertResult(1, 2, 1, 4, 5, 4)
  }
}
