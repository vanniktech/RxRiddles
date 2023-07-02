package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle21Solution
import io.reactivex.rxjava3.core.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/** Solution [Riddle21Solution] */
class Riddle21Test {
  @Test fun solve() {
    assertThat(Riddle21.solve(Observable.just(1, 2, 3))).isEqualTo(1)
  }
}
