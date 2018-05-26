package com.vanniktech.rxriddles.solutions

import io.reactivex.Single

object Riddle14Solution {
  fun solve(source: Single<Unit>)
      = source.retry(2) { it !is IllegalArgumentException }
}
