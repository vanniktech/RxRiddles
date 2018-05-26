package com.vanniktech.rxriddles.solutions

import io.reactivex.Single

object Riddle30Solution {
  fun solve(source: Single<Int>, function: () -> Unit)
      = source.doOnSubscribe { function.invoke() }
}
