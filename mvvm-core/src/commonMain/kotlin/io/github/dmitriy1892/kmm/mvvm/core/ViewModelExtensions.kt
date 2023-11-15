package io.github.dmitriy1892.kmm.mvvm.core

import kotlin.reflect.KClass

const val VIEW_MODEL_KEY_PREFIX = "androidx.lifecycle.ViewModelProvider.DefaultKey"

fun <T: Any> KClass<T>.viewModelKey(): String = "$VIEW_MODEL_KEY_PREFIX:${this.qualifiedName}"