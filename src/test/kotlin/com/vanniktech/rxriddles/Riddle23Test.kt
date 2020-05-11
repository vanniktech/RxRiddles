package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle23Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle23Solution] */
class Riddle23Test {
  @Test fun solve() {
    Riddle23.solve(Observable.just<Any>("bar", "foo"))
        .test()
        .assertResult("bar", "foo")
  }
}
