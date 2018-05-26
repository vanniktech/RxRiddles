package com.vanniktech.rxriddles.solutions

import io.reactivex.Single
import io.reactivex.functions.BiFunction

object Riddle6Solution {
  fun solve(first: Single<Int>, second: Single<Int>)
      = Single.zip(first, second, BiFunction<Int, Int, Pair<Int, Int>> { t1, t2 -> t1 to t2 })
}
