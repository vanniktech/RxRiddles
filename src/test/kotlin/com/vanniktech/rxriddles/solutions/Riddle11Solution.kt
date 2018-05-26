package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle11Solution {
  fun solve(source: Observable<Unit>)
      = source.throttleFirst(300, MILLISECONDS)
}
