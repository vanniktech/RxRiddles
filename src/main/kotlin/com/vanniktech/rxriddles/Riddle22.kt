package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle22 {
  /**
   * Group emissions of the [source] always in a list of 2 elements and skip every third element.
   *
   * Use case: Group related data while skipping over some of it.
   */
  fun solve(source: Observable<Int>): Observable<List<Int>> {
    TODO()
  }
}
