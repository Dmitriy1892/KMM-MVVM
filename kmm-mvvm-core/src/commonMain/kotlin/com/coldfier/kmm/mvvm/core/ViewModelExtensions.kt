package com.coldfier.kmm.mvvm.core

import kotlin.reflect.KClass

fun <T: Any> KClass<T>.viewModelKey(): String = this.qualifiedName!!