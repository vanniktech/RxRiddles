package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

object Riddle35 {
  /**
   * Return a Single that emits the value from the [first] source if present, otherwise emit from the [second] source.
   *
   * Use case: You have a local cache and only want to hit the network if the cache misses.
   */
  fun solve(first: Maybe<String>, second: Single<String>): Single<String> {
    TODO()
  }
}
