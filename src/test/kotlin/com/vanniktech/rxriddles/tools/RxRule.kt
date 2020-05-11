package com.vanniktech.rxriddles.tools

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.TimeUnit

/**
 * Rule to override all Schedulers with a custom TestScheduler.
 *
 * Please refrain from using this in production.
 * The best way to handle Schedulers is to inject them into the necessary class.
 * I didn't do this here though, to ease solving the riddles and keep everything as simple as possible.
 */
class RxRule(private val testScheduler: TestScheduler = TestScheduler()) : Scheduler(), TestRule {
  override fun apply(base: Statement, description: Description): Statement = object : Statement() {
    override fun evaluate() {
      // Override all of the default schedulers so we can use our testScheduler when testing.
      RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
      RxJavaPlugins.setIoSchedulerHandler { testScheduler }
      RxJavaPlugins.setSingleSchedulerHandler { testScheduler }
      RxJavaPlugins.setNewThreadSchedulerHandler { testScheduler }

      try {
        base.evaluate()
      } finally {
        RxJavaPlugins.reset()
      }
    }
  }

  override fun createWorker() = testScheduler.createWorker()

  fun advanceTimeBy(delayTime: Long, unit: TimeUnit) = testScheduler.advanceTimeBy(delayTime, unit)

  fun triggerActions() = testScheduler.triggerActions()
}
