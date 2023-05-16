package com.coldfier.kmm.mvvm.core

fun <T: Any> Class<T>.viewModelKey() = this.canonicalName!!