package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle2Solution {
  fun solve(source: Observable<Int>)
      = source.map { it + 1 }
}
