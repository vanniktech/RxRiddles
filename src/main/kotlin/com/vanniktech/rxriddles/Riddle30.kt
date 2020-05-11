package com.vanniktech.rxriddles

import io.reactivex.rxjava3.core.Single

object Riddle30 {
  /**
   * Call the given [function] when the [source] is being subscribed to.
   *
   * Use case: Add some logging.
   */
  fun solve(source: Single<Int>, function: () -> Unit): Single<Int> {
    TODO()
  }
}
