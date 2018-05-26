package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle15Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = Observable.concatEager(listOf(first, second))
}
