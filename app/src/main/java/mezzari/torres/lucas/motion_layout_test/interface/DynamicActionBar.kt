package mezzari.torres.lucas.motion_layout_test.`interface`

import androidx.appcompat.widget.Toolbar


interface DynamicActionBar {
    fun updateActionBar(toolbar: Toolbar)
    fun resetActionBar()
}