package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle24Solution {
  fun solve(source: Observable<Any>)
      = source.count()
}
