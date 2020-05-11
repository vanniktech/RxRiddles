package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit.SECONDS

object Riddle32Solution {
  fun solve(source: Single<Long>)
      = source.timeout(3, SECONDS)
}
