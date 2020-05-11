package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle13 {
  /**
   * When the [source] emits the same value as it did last time, don't allow it to travel downstream.
   *
   * Use case: You only want to observe changes of a value but don't care if the same value has been emitted consecutively.
   */
  fun solve(source: Observable<Int>): Observable<Int> {
    TODO()
  }
}
