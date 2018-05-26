package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle17Solution
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger

/** Solution [Riddle17Solution] */
class Riddle17Test {
  @Test fun solve() {
    val value = AtomicInteger(1)
    val s = Riddle17.solve({ value.get() })

    value.set(3)

    s.test()
        .assertResult(3)
  }
}
