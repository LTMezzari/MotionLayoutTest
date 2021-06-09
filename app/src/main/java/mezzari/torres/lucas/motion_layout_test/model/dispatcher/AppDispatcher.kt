package mezzari.torres.lucas.motion_layout_test.model.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
class AppDispatcher(
    override var main: CoroutineContext = Dispatchers.Main,
    override var io: CoroutineContext = Dispatchers.IO
) : IAppDispatcher