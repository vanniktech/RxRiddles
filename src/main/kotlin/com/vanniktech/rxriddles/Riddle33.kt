package com.vanniktech.rxriddles

import io.reactivex.Completable
import io.reactivex.Scheduler

object Riddle33 {
  /**
   * Shift all downstream work of [source] to the given [scheduler].
   *
   * Use case: You want to shift work to a particular [Scheduler].
   */
  fun solve(source: Completable, scheduler: Scheduler): Completable {
    TODO()
  }
}
