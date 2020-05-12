package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle35Solution
import com.vanniktech.rxriddles.tools.RxRule
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import org.junit.Rule
import org.junit.Test

/** Solution [Riddle35Solution] */
class Riddle35Test {
  @get:Rule val rxRule = RxRule()

  @Test fun hit() {
    val first = Maybe.just("First")
    val second = Single.just("Second")

    Riddle35.solve(first, second)
        .test()
        .assertResult("First")
  }

  @Test fun miss() {
    val first = Maybe.empty<String>()
    val second = Single.just("Second")

    Riddle35.solve(first, second)
        .test()
        .assertResult("Second")
  }
}
