package mezzari.torres.lucas.motion_layout_test.network.module

import mezzari.torres.lucas.motion_layout_test.network.adapter.RetrofitCallAdapterFactory
import mezzari.torres.lucas.network.source.Network
import retrofit2.Retrofit

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
class DeferredModule: Network.RetrofitLevelModule {
    override fun onRetrofitBuilderCreated(retrofitBuilder: Retrofit.Builder) {
        retrofitBuilder.addCallAdapterFactory(RetrofitCallAdapterFactory())
    }
}