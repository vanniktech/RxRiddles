package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable

object Riddle10Solution {
  fun solve(first: Observable<Int>, function: (Int) -> Observable<String>)
      = first.flatMap(function) { t1, t2 -> t1 to t2 }
}
