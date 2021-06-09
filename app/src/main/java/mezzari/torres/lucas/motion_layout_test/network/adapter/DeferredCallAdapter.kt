package mezzari.torres.lucas.motion_layout_test.network.adapter

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import mezzari.torres.lucas.motion_layout_test.network.config.Response
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import java.lang.reflect.Type

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
class DeferredCallAdapter<R>(
    private val responseType: Type,
): CallAdapter<R, Deferred<Response<R>>> {
    override fun responseType(): Type = responseType

    override fun adapt(call: Call<R>): Deferred<Response<R>> {
        val deferred = CompletableDeferred<Response<R>>()

        val callback = object: Callback<R> {
            override fun onResponse(call: Call<R>, response: retrofit2.Response<R>) {
                if (response.isSuccessful) {
                    deferred.complete(Response.create(response))
                }
            }

            override fun onFailure(call: Call<R>, t: Throwable) {
                deferred.complete(Response.create(t))
            }
        }

        call.enqueue(callback)
        return deferred
    }
}