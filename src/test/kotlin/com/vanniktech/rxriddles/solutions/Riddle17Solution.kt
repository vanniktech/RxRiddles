package com.vanniktech.rxriddles.solutions

import io.reactivex.Single

object Riddle17Solution {
  fun solve(function: () -> Int)
      = Single.fromCallable(function)
}
