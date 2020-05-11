package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle27Solution {
  fun solve(source: Observable<Long>, function: (Long) -> Unit)
      = source.doOnNext(function)
}
