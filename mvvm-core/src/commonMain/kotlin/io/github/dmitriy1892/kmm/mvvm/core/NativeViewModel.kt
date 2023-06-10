package io.github.dmitriy1892.kmm.mvvm.core

import kotlinx.coroutines.CoroutineScope

expect abstract class NativeViewModel() {

    protected abstract val viewModelScope: CoroutineScope

    protected open fun onCleared()
}