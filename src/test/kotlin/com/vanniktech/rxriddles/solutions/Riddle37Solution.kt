package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.io.IOException

object Riddle37Solution {
  fun solve(source: Observable<Boolean>)
      = source.onErrorResumeNext { t: Throwable ->
        when (t) {
          is IOException -> Observable.just(false)
          else -> Observable.error(t)
        }
      }
}
