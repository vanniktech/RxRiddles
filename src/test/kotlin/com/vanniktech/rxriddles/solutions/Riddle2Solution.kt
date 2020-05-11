package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle2Solution {
  fun solve(source: Observable<Int>)
      = source.map { it + 1 }
}
