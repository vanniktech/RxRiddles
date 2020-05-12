package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS

object Riddle36Solution {
  fun solve(source: Observable<String>, milliseconds: Long)
      = source.debounce(milliseconds, MILLISECONDS)
}
