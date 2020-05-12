package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle11 {
  /**
   * Let the first emission of the [source] within a time window of 300ms travel downstream but don't emit any other events until the next time window.
   *
   * Use case: Handle the click of a button right away but prevent double clicking by not handling multiple click events within a given time window.
   */
  fun solve(source: Observable<Unit>): Observable<Unit> {
    TODO()
  }
}
