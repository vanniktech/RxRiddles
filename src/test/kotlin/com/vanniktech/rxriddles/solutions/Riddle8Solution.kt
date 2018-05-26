package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle8Solution {
  fun solve(source: Observable<Unit>)
      = source.delaySubscription(200, MILLISECONDS)
}
