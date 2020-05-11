package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers

object Riddle102Solution {
  fun solve(first: Single<Int>, second: Single<Int>) = Single.zip(
      first.subscribeOn(Schedulers.io()),
      second.subscribeOn(Schedulers.io()),
      BiFunction<Int, Int, Pair<Int, Int>> { t1, t2 -> t1 to t2 }
  )
}
