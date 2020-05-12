package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle13Solution {
  fun solve(source: Observable<Int>)
      = source.distinctUntilChanged()
}
