package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit.SECONDS

object Riddle101Solution {
  fun solve(seconds: Long)
      = Observable.rangeLong(-seconds, seconds + 1)
      .flatMapSingle { time -> Single.timer(time + seconds, SECONDS).map { Math.abs(time) } }
}
