package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import io.reactivex.Single

object Riddle16Solution {
  fun solve(first: Observable<String>, second: (String) -> Single<Int>)
      = first.switchMapSingle { second.invoke(it) }
}
