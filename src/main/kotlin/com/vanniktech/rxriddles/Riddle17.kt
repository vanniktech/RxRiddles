package com.vanniktech.rxriddles

import io.reactivex.Single

object Riddle17 {
  /**
   * Return a Single that emits the value from the given [function] when being subscribed to.
   *
   * Use case: Reactive types are lazy by default. Hence you might also want to get the value upon the subscription and not execution time.
   */
  fun solve(function: () -> Int): Single<Int> {
    TODO()
  }
}
