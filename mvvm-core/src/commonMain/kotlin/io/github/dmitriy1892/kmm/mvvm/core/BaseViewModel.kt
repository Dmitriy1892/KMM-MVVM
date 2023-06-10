package io.github.dmitriy1892.kmm.mvvm.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.ThreadLocal

open class BaseViewModel : NativeViewModel() {

    @ThreadLocal
    companion object {
        private var sharedExceptionHandler: CoroutineExceptionHandler? = null

        fun setupSharedExceptionHandler(exceptionHandler: CoroutineExceptionHandler) {
            sharedExceptionHandler = exceptionHandler
        }
    }

    private val mainCoroutineExceptionHandler: CoroutineExceptionHandler? by lazy(
        LazyThreadSafetyMode.NONE
    ) { getCoroutineExceptionHandler() }

    private val mainCoroutineContext: CoroutineContext by lazy {
        (Dispatchers.Main.immediate + SupervisorJob()).run {
            val exceptionHandler = mainCoroutineExceptionHandler ?: return@run this
            this + exceptionHandler
        }
    }

    override val viewModelScope: CoroutineScope by lazy { CoroutineScope(mainCoroutineContext) }

    fun clear() {
        onCleared()
    }

    /**
     * Function for getting a [CoroutineExceptionHandler].
     * It used [sharedExceptionHandler] by default.
     * If you need to use specific [CoroutineExceptionHandler], you can override this function
     * and define your own [CoroutineExceptionHandler]
     *
     * @return [CoroutineExceptionHandler] or null
     */
    protected open fun getCoroutineExceptionHandler(): CoroutineExceptionHandler? =
        sharedExceptionHandler
}