package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction

object Riddle5Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = Observable.combineLatest(first, second, BiFunction<Int, Int, Int> { t1, t2 -> t1 + t2 })
}
