package mezzari.torres.lucas.motion_layout_test.network.config

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.FlowCollector

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
class NetworkBoundResource<ResultType, RequestType> private constructor (
    private val collector: FlowCollector<Resource<ResultType>>,
    private val call: Deferred<Response<RequestType>>,
    private val processResponse: (response: RequestType?) -> ResultType
) {

    private suspend fun execute() {
        collector.emit(Resource.loading())
        return when (val result = call.await()) {
            is Response.Success -> {
                val process = processResponse(result.data)
                collector.emit(Resource.success(process))
            }
            is Response.Failure -> {
                collector.emit(Resource.error(result.error, null))
            }
        }
    }

    companion object {
        suspend operator fun <ResultType, RequestType>invoke (
            collector: FlowCollector<Resource<ResultType>>,
            call: Deferred<Response<RequestType>>,
            processResponse: (response: RequestType?) -> ResultType
        ): NetworkBoundResource<ResultType, RequestType> {
            return NetworkBoundResource(collector, call, processResponse).also {
                it.execute()
            }
        }
    }
}