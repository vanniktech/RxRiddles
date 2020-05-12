package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

object Riddle35Solution {
  fun solve(first: Maybe<String>, second: Single<String>)
      = first.switchIfEmpty(second)
}
