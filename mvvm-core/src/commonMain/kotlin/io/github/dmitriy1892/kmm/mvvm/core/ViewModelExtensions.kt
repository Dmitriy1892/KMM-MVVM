package io.github.dmitriy1892.kmm.mvvm.core

import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC
import kotlin.reflect.KClass

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
const val VIEW_MODEL_KEY_PREFIX = "androidx.lifecycle.ViewModelProvider.DefaultKey"

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
fun <T: Any> KClass<T>.viewModelKey(): String = "$VIEW_MODEL_KEY_PREFIX:${this.qualifiedName}"