package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

object Riddle16Solution {
  fun solve(source: Observable<String>, function: (String) -> Single<Int>)
      = source.switchMapSingle(function)
}
