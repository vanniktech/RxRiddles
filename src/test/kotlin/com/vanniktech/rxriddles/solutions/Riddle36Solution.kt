package com.vanniktech.rxriddles.solutions

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object Riddle36Solution {

  fun solve(source: Observable<String>, milliseconds: Long): Observable<String> =
    source.debounce(milliseconds, TimeUnit.MILLISECONDS)

}
