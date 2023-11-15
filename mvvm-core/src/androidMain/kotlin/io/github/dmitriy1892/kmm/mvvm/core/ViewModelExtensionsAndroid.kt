package io.github.dmitriy1892.kmm.mvvm.core

fun <T: Any> Class<T>.viewModelKey() = "$VIEW_MODEL_KEY_PREFIX:${this.canonicalName}"