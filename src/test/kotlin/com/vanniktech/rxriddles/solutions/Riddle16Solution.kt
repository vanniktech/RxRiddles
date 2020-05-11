package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import io.reactivex.Single

object Riddle16Solution {
  fun solve(source: Observable<String>, function: (String) -> Single<Int>)
      = source.switchMapSingle(function)
}
