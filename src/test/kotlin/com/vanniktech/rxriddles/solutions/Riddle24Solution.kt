package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle24Solution {
  fun solve(source: Observable<Any>)
      = source.count()
}
