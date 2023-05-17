package by.vebtech.app.kmm.sample.di

import com.coldfier.kmm.utils.coroutines.withThreadLock
import com.coldfier.kmm.utils.platform.PlatformConfiguration
import kotlinx.coroutines.sync.Mutex
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.native.concurrent.ThreadLocal

class KoinDiHolder private constructor(di: KoinApplication) {

    val koin: Koin by lazy { di.koin }

    @ThreadLocal
    companion object {
        private var INSTANCE: KoinDiHolder? = null
        private val mutex = Mutex()

        fun getInstance(platformConfiguration: PlatformConfiguration): KoinDiHolder {
            return mutex.withThreadLock {
                INSTANCE ?: run {
                    val koinApp = startKoin {
                        modules(
                            module { single { platformConfiguration } },
                            viewModelsModule
                        )
                    }

                    INSTANCE = KoinDiHolder(koinApp)

                    INSTANCE!!
                }
            }
        }
    }
}