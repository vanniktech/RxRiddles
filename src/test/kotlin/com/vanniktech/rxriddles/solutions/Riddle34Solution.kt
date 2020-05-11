package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler

object Riddle34Solution {
  fun solve(source: Completable, scheduler: Scheduler)
      = source.subscribeOn(scheduler)
}
