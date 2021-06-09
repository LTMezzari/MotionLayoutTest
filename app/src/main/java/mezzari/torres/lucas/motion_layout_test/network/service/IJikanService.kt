package mezzari.torres.lucas.motion_layout_test.network.service

import kotlinx.coroutines.flow.Flow
import mezzari.torres.lucas.motion_layout_test.network.config.Resource

/**
 * @author Lucas T. Mezzari
 * @since 09/06/2021
 */
interface IJikanService {
    fun getService(year: Int, season: String): Flow<Resource<Any?>>
}