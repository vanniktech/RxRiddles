package com.vanniktech.rxriddles.solutions

import io.reactivex.rxjava3.core.Completable

object Riddle28Solution {
  fun solve(source: Completable, function: () -> Unit)
      = source.doOnComplete(function)
}
