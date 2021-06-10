package mezzari.torres.lucas.motion_layout_test.di

import mezzari.torres.lucas.motion_layout_test.model.dispatcher.AppDispatcher
import mezzari.torres.lucas.motion_layout_test.model.dispatcher.IAppDispatcher
import mezzari.torres.lucas.motion_layout_test.network.IJikanAPI
import mezzari.torres.lucas.motion_layout_test.network.service.IJikanService
import mezzari.torres.lucas.motion_layout_test.network.service.JikanService
import mezzari.torres.lucas.motion_layout_test.ui.news.NewsViewModel
import mezzari.torres.lucas.network.source.Network
import org.koin.androidx.viewmodel.dsl.viewModel
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
    single<IJikanService> { JikanService(get()) }
}

private val viewModelModule = module {
    viewModel { NewsViewModel(get(), get()) }
}

val appModule = listOf(coroutineModule, networkModule, viewModelModule)