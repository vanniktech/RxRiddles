package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Single

object Riddle17Solution {
  fun solve(function: () -> Int)
      = Single.fromCallable(function)
}
