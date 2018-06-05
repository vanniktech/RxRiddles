package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle36Solution {
  fun solve(source: Observable<String>, milliseconds: Long)
      = source.debounce(milliseconds, MILLISECONDS)
}
