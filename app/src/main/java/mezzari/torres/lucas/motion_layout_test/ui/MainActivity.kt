package mezzari.torres.lucas.motion_layout_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import mezzari.torres.lucas.motion_layout_test.`interface`.DynamicActionBar
import mezzari.torres.lucas.motion_layout_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DynamicActionBar {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setDefaultActionBar()
    }

    override fun updateActionBar(toolbar: Toolbar) {
        supportActionBar?.hide()
        setSupportActionBar(toolbar)
    }

    override fun resetActionBar() {
        setDefaultActionBar()
        supportActionBar?.show()
    }

    private fun setDefaultActionBar() {
        setSupportActionBar(binding.activityToolbar)
    }
}