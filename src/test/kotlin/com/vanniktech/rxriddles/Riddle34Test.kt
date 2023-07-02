package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle34Solution
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.Executors

/** Solution [Riddle34Solution] */
class Riddle34Test {
  @Test fun solve() {
    val threads = mutableListOf<String>()

    val completable = Completable.fromAction {
      threads.add(Thread.currentThread().name)
    }

    val first = Schedulers.from(Executors.newSingleThreadExecutor { Thread(it, "First thread") })
    val second = Schedulers.from(Executors.newSingleThreadExecutor { Thread(it, "Second thread") })
    Riddle34.solve(completable, first)
        .doOnComplete { threads.add(Thread.currentThread().name) }
        .observeOn(second)
        .doOnComplete { threads.add(Thread.currentThread().name) }
        .test()
        .await()
        .assertResult()

    assertThat(threads).containsExactly("First thread", "First thread", "Second thread")
  }
}
