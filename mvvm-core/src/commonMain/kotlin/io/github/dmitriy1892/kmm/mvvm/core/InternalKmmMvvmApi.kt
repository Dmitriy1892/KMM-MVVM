package io.github.dmitriy1892.kmm.mvvm.core

import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
@Retention(value = AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPEALIAS,
    AnnotationTarget.PROPERTY
)
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR, message = "This is an internal KMM-MVVM API that " +
            "should not be used from outside of \"io.github.dmitriy1892.kmm.mvvm\". " +
            "No compatibility guarantees are provided. Use stable API instead"
)
annotation class InternalKmmMvvmApi
