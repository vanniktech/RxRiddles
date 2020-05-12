package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Single

object Riddle6 {
  /**
   * Execute both [first] and [second] Single's in parallel and provide both results as a pair.
   * Assume both [first] and [second] will execute on a different thread already.
   * This is a slightly simpler version of [Riddle102], where no schedulers are applied by default.
   *
   * Use case: Execute two network requests in parallel and wait for each other and process the combined data.
   */
  fun solve(first: Single<Int>, second: Single<Int>): Single<Pair<Int, Int>> {
    TODO()
  }
}
