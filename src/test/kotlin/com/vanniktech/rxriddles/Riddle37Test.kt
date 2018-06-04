package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle37Solution
import io.reactivex.Observable
import org.junit.Test
import java.io.IOException

/** Solution [Riddle37Solution] */
class Riddle37Test {

  @Test fun map() {
    val source = Observable.concat(Observable.just(true), Observable.error(IOException()))

    Riddle37.solve(source)
        .test()
        .assertResult(true, false)
  }

  @Test fun error() {
    val source = Observable.error<Boolean>(NullPointerException())

    Riddle37.solve(source)
        .test()
        .assertFailure(NullPointerException::class.java)
  }
}
