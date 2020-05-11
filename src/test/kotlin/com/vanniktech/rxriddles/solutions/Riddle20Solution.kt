package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle20Solution {
  fun solve(first: Observable<Int>, second: Observable<Int>)
      = first.mergeWith(second)
}
