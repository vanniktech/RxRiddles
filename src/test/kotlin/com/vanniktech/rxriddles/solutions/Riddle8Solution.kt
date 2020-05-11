package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle8Solution {
  fun solve(source: Observable<Unit>)
      = source.delaySubscription(200, MILLISECONDS)
}
