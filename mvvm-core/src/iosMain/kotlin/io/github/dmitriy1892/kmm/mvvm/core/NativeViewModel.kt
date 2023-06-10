package io.github.dmitriy1892.kmm.mvvm.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

actual abstract class NativeViewModel {

    protected actual abstract val viewModelScope: CoroutineScope

    protected actual open fun onCleared() {
        viewModelScope.cancel()
    }
}