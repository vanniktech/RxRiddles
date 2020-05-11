package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle15Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = Observable.concatEager(listOf(first, second))
}
