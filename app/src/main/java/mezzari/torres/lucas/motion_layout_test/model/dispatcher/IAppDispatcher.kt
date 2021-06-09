package mezzari.torres.lucas.motion_layout_test.model.dispatcher

import kotlin.coroutines.CoroutineContext

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
interface IAppDispatcher {
    var main: CoroutineContext
    var io: CoroutineContext
}