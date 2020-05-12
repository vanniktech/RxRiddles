package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit.SECONDS

object Riddle101Solution {
  fun solve(seconds: Long) = Observable.interval(0, 1, SECONDS)
      .map { ticksPassed -> seconds - ticksPassed }
      .takeUntil { it == 0L }
}
