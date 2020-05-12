package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle12 {
  /**
   * In case the [source] Observable emits an error, don't emit the error and instead complete the Observable with a value of 5.
   *
   * Use case: Getting a network error and you want to recover and show some default state.
   */
  fun solve(source: Observable<Int>): Observable<Int> {
    TODO()
  }
}
