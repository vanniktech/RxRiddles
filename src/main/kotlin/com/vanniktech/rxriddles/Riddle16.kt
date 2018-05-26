package com.vanniktech.rxriddles

import io.reactivex.Observable
import io.reactivex.Single

object Riddle16 {
  /**
   * For each emission of the [first] Observable use the [function] and return its value.
   * Dispose all previously non terminated returned Singles from the [function] upon receiving a new emission from [first].
   *
   * Use case: The [first] Observable is a TextField and you want to issue a network request while disposing the old requests in case the user has typed something new.
   */
  fun solve(first: Observable<String>, function: (String) -> Single<Int>): Observable<Int> {
    TODO()
  }
}
