package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.Riddle19.Interaction
import com.vanniktech.rxriddles.solutions.Riddle19Solution
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/** Solution [Riddle19Solution] */
class Riddle19Test {
  @Test fun solve() {
    val testInteraction = TestInteraction()
    val o = Riddle19.solve(testInteraction)
        .test()
        .assertEmpty()

    assertThat(testInteraction.listener).isNotNull()

    testInteraction.listener?.invoke(5)
    o.assertValuesOnly(5)

    testInteraction.listener?.invoke(10)
    o.assertValuesOnly(5, 10)

    o.dispose()
    assertThat(testInteraction.listener).isNull()
  }

  class TestInteraction : Interaction {
    private var internalListener: ((Int) -> Unit)? = null

    override var listener: ((Int) -> Unit)?
      get() = internalListener
      set(value) {
        internalListener = value
      }
  }
}
