package com.coldfier.kmm.mvvm.core

import kotlin.reflect.KClass

internal const val DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey"

fun <T: Any> KClass<T>.viewModelKey(): String = "$DEFAULT_KEY:${this.qualifiedName}"