package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle22Solution {
  fun solve(source: Observable<Int>)
      = source.buffer(2, 3)
}
