package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle26Solution {
  fun solve(source: Observable<Long>)
      = source.delay(300, MILLISECONDS)
}
