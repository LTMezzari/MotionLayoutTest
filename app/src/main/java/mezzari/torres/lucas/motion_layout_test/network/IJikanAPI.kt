package mezzari.torres.lucas.motion_layout_test.network

import kotlinx.coroutines.Deferred
import mezzari.torres.lucas.motion_layout_test.model.Anime
import mezzari.torres.lucas.motion_layout_test.model.network.ResponseWrapper
import mezzari.torres.lucas.motion_layout_test.network.config.Response
import mezzari.torres.lucas.network.annotation.Route
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 *
 * Endpoints from https://jikan.moe/
 */
@Route("https://api.jikan.moe/v3/")
interface IJikanAPI {
    @GET("season/{year}/{season}")
    fun getSeason(
        @Path("year") year: Int,
        @Path("season") season: String
    ): Deferred<Response<ResponseWrapper<List<Anime>>>>
}