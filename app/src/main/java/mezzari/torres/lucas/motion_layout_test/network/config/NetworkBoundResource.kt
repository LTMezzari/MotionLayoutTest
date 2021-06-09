package mezzari.torres.lucas.motion_layout_test.network.config

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.FlowCollector

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
class NetworkBoundResource<R> private constructor(
    private val collector: FlowCollector<Resource<R>>,
    private val call: Deferred<Response<R>>,
) {
    private suspend inline fun execute() {
        collector.emit(Resource.loading())
        return when (val result = call.await()) {
            is Response.Success -> {
                collector.emit(Resource.success(result.data))
            }
            is Response.Failure -> {
                collector.emit(Resource.error(result.error, result.data))
            }
        }
    }

    companion object {
        suspend operator fun <R> invoke(
            collector: FlowCollector<Resource<R>>,
            call: Deferred<Response<R>>,
        ): NetworkBoundResource<R> {
            return NetworkBoundResource(collector, call).also {
                it.execute()
            }
        }
    }
}