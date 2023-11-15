package io.github.dmitriy1892.kmm.mvvm.core

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.ViewModel

fun <T: Any> Class<T>.viewModelKey() = "$VIEW_MODEL_KEY_PREFIX:${this.canonicalName}"

/**
 * Delegate for [BaseViewModel] getting.
 * This workaround is needed for error non-highlighting while using [viewModels] delegate from android code,
 * because compiler is not see the extended expect class [NativeViewModel] that extends android's [ViewModel]
 */
@MainThread
inline fun <reified VM : BaseViewModel> ComponentActivity.kmmViewModels(
    noinline extrasProducer: (() -> CreationExtras)? = null,
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> = this.viewModels(extrasProducer = extrasProducer, factoryProducer = factoryProducer)

/**
 * Delegate for [BaseViewModel] getting.
 * This workaround is needed for error non-highlighting while using [viewModels] delegate from android code,
 * because compiler is not see the extended expect class [NativeViewModel] that extends android's [ViewModel]
 */
@MainThread
inline fun <reified VM : BaseViewModel> Fragment.kmmViewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline extrasProducer: (() -> CreationExtras)? = null,
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
): Lazy<VM> = this.viewModels(
    ownerProducer = ownerProducer,
    extrasProducer = extrasProducer,
    factoryProducer = factoryProducer
)