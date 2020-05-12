package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle31Solution {
  fun solve(source: Observable<Int>)
      = source.repeat(3)
}
