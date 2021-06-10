package mezzari.torres.lucas.motion_layout_test.generic

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import mezzari.torres.lucas.motion_layout_test.`interface`.DynamicActionBar

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
abstract class BaseFragment: Fragment() {
    protected val navController: NavController get() = findNavController()

    protected var hasToolbarUpdate: Boolean = true
    protected var shouldShowActionBar: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(hasToolbarUpdate)
    }

    @CallSuper
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        setActionBar()
        setActionBarVisibility(shouldShowActionBar)
    }

    @CallSuper
    override fun onDestroyOptionsMenu() {
        resetActionBar()
        setActionBarVisibility(true)
    }

    private fun setActionBar() {
        val dynamicActionBar = activity as? DynamicActionBar ?: return
        val actionBar = getActionBar() ?: return
        dynamicActionBar.updateActionBar(actionBar)
    }

    private fun resetActionBar() {
        val dynamicActionBar = activity as? DynamicActionBar ?: return
        dynamicActionBar.resetActionBar()
    }

    private fun setActionBarVisibility(shouldShowActionBar: Boolean) {
        val appCompatActivity = activity as? AppCompatActivity ?: return
        if (shouldShowActionBar) {
            appCompatActivity.supportActionBar?.show()
            return
        }
        appCompatActivity.supportActionBar?.hide()
    }

    protected open fun getActionBar(): Toolbar? = null
}