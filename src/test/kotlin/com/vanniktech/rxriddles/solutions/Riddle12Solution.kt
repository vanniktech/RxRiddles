package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle12Solution {
  fun solve(source: Observable<Int>)
      = source.onErrorReturnItem(5)
}
