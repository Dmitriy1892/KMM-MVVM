package io.github.dmitriy1892.kmm.mvvm.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

actual abstract class NativeViewModel : ViewModel() {

    protected actual abstract val viewModelScope: CoroutineScope

    actual override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}