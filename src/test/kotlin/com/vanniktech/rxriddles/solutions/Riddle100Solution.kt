package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle100Solution {
  fun solve(source: Observable<Unit>) = source.buffer(300, MILLISECONDS)
      .filter { it.size > 1 }
      .map { }
}
