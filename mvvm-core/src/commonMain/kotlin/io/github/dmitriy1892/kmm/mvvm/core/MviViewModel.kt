package io.github.dmitriy1892.kmm.mvvm.core

import io.github.dmitriy1892.kmm.utils.coroutines.WrappedFlow
import io.github.dmitriy1892.kmm.utils.coroutines.WrappedStateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow

abstract class MviViewModel<State: Any, SideEffect: Any> : BaseViewModel() {

    protected abstract val _screenState: MutableStateFlow<State>
    val screenState: WrappedStateFlow<State>
        get() = WrappedStateFlow(_screenState.asStateFlow())

    protected val sideEffectChannel = Channel<SideEffect>()
    val sideEffectFlow: WrappedFlow<SideEffect> =
        WrappedFlow(sideEffectChannel.receiveAsFlow().flowOn(Dispatchers.Main.immediate))
}