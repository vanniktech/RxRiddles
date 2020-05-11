package com.vanniktech.rxriddles.solutions

import io.reactivex.Maybe

object Riddle29Solution {
  fun solve(source: Maybe<Int>, function: (Throwable) -> Unit)
      = source.doOnError(function)
}
