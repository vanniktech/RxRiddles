package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle9 {
  /**
   * As long as the [trigger] Observable does not emit an item, keep the [main] Observable alive.
   *
   * Use case: Cancel an Observable when something has happened. For instance, stop polling when the user has been logged out.
   */
  fun solve(main: Observable<Unit>, trigger: Observable<Unit>): Observable<Unit> {
    TODO()
  }
}
