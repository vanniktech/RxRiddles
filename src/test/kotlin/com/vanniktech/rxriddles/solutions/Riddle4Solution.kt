package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Observable

object Riddle4Solution {
  fun solve(source: Observable<Unit>)
      = source.scan(false) { toggle, _ -> !toggle }
}
