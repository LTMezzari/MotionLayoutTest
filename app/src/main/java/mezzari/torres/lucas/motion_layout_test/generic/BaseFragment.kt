package mezzari.torres.lucas.motion_layout_test.generic

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
abstract class BaseFragment: Fragment() {
    protected val navController: NavController get() = findNavController()
}