package mezzari.torres.lucas.motion_layout_test.di

import mezzari.torres.lucas.motion_layout_test.model.dispatcher.AppDispatcher
import mezzari.torres.lucas.motion_layout_test.model.dispatcher.IAppDispatcher
import mezzari.torres.lucas.motion_layout_test.network.IJikanAPI
import mezzari.torres.lucas.network.source.Network
import org.koin.dsl.module

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
private val coroutineModule = module {
    single<IAppDispatcher> { AppDispatcher() }
}

private val networkModule = module {
    single<IJikanAPI> { Network.build(IJikanAPI::class) }
}

val appModule = listOf(coroutineModule, networkModule)