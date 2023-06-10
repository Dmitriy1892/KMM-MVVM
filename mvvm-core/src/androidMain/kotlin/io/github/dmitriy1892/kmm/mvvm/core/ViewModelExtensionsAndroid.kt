package io.github.dmitriy1892.kmm.mvvm.core

fun <T: Any> Class<T>.viewModelKey() = "$DEFAULT_KEY:${this.canonicalName}"