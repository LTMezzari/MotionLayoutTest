package mezzari.torres.lucas.motion_layout_test

import android.app.Application
import mezzari.torres.lucas.motion_layout_test.di.appModule
import mezzari.torres.lucas.motion_layout_test.network.module.DeferredModule
import mezzari.torres.lucas.network.source.Network
import mezzari.torres.lucas.network.source.module.client.LogModule
import mezzari.torres.lucas.network.source.module.retrofit.GsonConverterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Network.initialize(
            retrofitLevelModules = listOf(GsonConverterModule(), DeferredModule()),
            okHttpClientLevelModule = listOf(LogModule()),
        )
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}