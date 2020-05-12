package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

object Riddle16 {
  /**
   * For each emission of the [source] Observable use the [function] and return its value.
   * Dispose all previously non terminated returned Singles from the [function] upon receiving a new emission from [source].
   *
   * Use case: The [source] Observable is a TextField and you want to issue a network request while disposing the old requests in case the user has typed something new.
   */
  fun solve(source: Observable<String>, function: (String) -> Single<Int>): Observable<Int> {
    TODO()
  }
}
