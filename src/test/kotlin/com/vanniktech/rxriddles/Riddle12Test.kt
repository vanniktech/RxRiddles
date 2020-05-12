package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle12Solution
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

/** Solution [Riddle12Solution] */
class Riddle12Test {
  @Test fun solve() {
    Riddle12.solve(Observable.create {
      it.onNext(1)
      it.onNext(2)
      it.onError(RuntimeException())
    })
        .test()
        .assertResult(1, 2, 5)
  }
}
