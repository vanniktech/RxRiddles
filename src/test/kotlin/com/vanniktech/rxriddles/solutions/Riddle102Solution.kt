package com.vanniktech.rxriddles.solutions

import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object Riddle102Solution {
  fun solve(first: Single<Int>, second: Single<Int>) = Single.zip(
      first.subscribeOn(Schedulers.io()),
      second.subscribeOn(Schedulers.io()),
      BiFunction<Int, Int, Pair<Int, Int>> { t1, t2 -> t1 to t2 }
  )
}
