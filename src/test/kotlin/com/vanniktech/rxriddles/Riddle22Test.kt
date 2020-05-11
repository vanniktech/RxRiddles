package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle22Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle22Solution] */
class Riddle22Test {
  @Test fun solve() {
    Riddle22.solve(Observable.range(0, 10))
        .test()
        .assertResult(listOf(0, 1), listOf(3, 4), listOf(6, 7), listOf(9))
  }
}
