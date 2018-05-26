package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle27Solution {
  fun solve(source: Observable<Long>, function: (Long) -> Unit)
      = source.doOnNext { function.invoke(it) }
}
