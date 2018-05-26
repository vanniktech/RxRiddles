package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle1Solution
import org.junit.Test

/** Solution [Riddle1Solution] */
class Riddle1Test {
  @Test fun solve() {
    Riddle1.solve(5)
        .test()
        .assertResult(5)
  }
}
