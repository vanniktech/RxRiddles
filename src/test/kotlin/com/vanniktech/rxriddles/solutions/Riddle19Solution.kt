package com.vanniktech.rxriddles.solutions

import com.vanniktech.rxriddles.Riddle19.Interaction
import io.reactivex.rxjava3.core.Observable

object Riddle19Solution {
  fun solve(interaction: Interaction)
      = Observable.create<Int> { emitter ->
        interaction.listener = emitter::onNext

        emitter.setCancellable {
          interaction.listener = null
        }
      }
}
