package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle27 {
  /**
   * Call the given [function] each time the [source] emits a value.
   *
   * Use case: Add some logging.
   */
  fun solve(source: Observable<Long>, function: (Long) -> Unit): Observable<Long> {
    TODO()
  }
}
