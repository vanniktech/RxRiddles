package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle13Solution {
  fun solve(source: Observable<Int>)
      = source.distinctUntilChanged()
}
