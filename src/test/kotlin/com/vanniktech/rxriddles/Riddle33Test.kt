package com.vanniktech.rxriddles

import com.vanniktech.rxriddles.solutions.Riddle33Solution
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.Executors

/** Solution [Riddle33Solution] */
class Riddle33Test {
  @Test fun solve() {
    val threads = mutableListOf<String>()

    val completable = Completable.fromAction {
      threads.add(Thread.currentThread().name)
    }

    val first = Schedulers.from(Executors.newSingleThreadExecutor { Thread(it, "First thread") })
    val second = Schedulers.from(Executors.newSingleThreadExecutor { Thread(it, "Second thread") })
    Riddle33.solve(completable, first)
        .doOnComplete { threads.add(Thread.currentThread().name) }
        .subscribeOn(second)
        .test()
        .await()
        .assertResult()

    assertThat(threads).containsExactly("Second thread", "First thread")
  }
}
