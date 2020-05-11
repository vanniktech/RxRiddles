package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle3Solution {
  fun solve(source: Observable<Int>)
      = source.filter { it.rem(2) == 0 }
}
