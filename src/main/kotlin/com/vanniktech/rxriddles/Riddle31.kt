package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle31 {
  /**
   * Duplicate the entire [source] three times. After emitting all events three times it should complete.
   *
   * Use case: You want to re-run a certain Observable a number of times.
   */
  fun solve(source: Observable<Int>): Observable<Int> {
    return source.repeat(3)
  }
}
