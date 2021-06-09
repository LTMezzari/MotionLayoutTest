package mezzari.torres.lucas.motion_layout_test.network.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mezzari.torres.lucas.motion_layout_test.network.IJikanAPI
import mezzari.torres.lucas.motion_layout_test.network.config.NetworkBoundResource
import mezzari.torres.lucas.motion_layout_test.network.config.Resource

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
class JikanService(private val api: IJikanAPI): IJikanService {
    override fun getService(year: Int, season: String): Flow<Resource<Any?>> {
        return flow {
            NetworkBoundResource(
                this,
                api.getSeason(year, season)
            ) {
                it
            }
        }
    }
}