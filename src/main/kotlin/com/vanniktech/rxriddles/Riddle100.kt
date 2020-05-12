package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable

object Riddle100 {
  /**
   * If the [source] emits more than once within 300ms we want to emit [Unit].
   * If there is only one or non emissions within 300ms we don't want to emit anything.
   *
   * Use case: Double click detection mechanism for a button.
   */
  fun solve(source: Observable<Unit>): Observable<Unit> {
    TODO()
  }
}
