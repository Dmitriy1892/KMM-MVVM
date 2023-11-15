package io.github.dmitriy1892.kmm.mvvm.core

import io.github.dmitriy1892.kmm.utils.coroutines.flow.EventMutableSharedFlow
import io.github.dmitriy1892.kmm.utils.coroutines.flow.WrappedSharedFlow
import io.github.dmitriy1892.kmm.utils.coroutines.flow.WrappedStateFlow
import io.github.dmitriy1892.kmm.utils.coroutines.flow.asWrappedSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class UdfViewModel<State: Any, SideEffect: Any> : BaseViewModel() {

    protected abstract val _screenState: MutableStateFlow<State>
    val screenState: WrappedStateFlow<State>
        get() = WrappedStateFlow(_screenState.asStateFlow())

    protected val _sideEffectFlow = EventMutableSharedFlow<SideEffect>()
    val sideEffectFlow: WrappedSharedFlow<SideEffect>
        get() = _sideEffectFlow.asWrappedSharedFlow()
}