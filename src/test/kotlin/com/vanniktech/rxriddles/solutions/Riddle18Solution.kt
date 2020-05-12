package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle18Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = Observable.ambArray(first, second)
}
