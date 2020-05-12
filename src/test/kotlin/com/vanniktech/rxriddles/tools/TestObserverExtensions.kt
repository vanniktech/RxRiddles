package com.vanniktech.rxriddles.tools

import io.reactivex.rxjava3.observers.TestObserver

fun <T> TestObserver<T>.awaitTerminalEvent(): Boolean {
    return try {
        await()
        true
    } catch (ex: InterruptedException) {
        Thread.currentThread().interrupt()
        false
    }
}