package com.vanniktech.rxriddles.solutions

import io.reactivex.Completable

object Riddle28Solution {
  fun solve(source: Completable, function: () -> Unit)
      = source.doOnComplete(function)
}
