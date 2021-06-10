package mezzari.torres.lucas.motion_layout_test.ui.splash

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import mezzari.torres.lucas.motion_layout_test.R
import mezzari.torres.lucas.motion_layout_test.databinding.FragmentSplashBinding
import mezzari.torres.lucas.motion_layout_test.generic.BaseFragment

/**
 * @author Lucas T. Mezzari
 * @since 07/06/2021
 */
class SplashFragment: BaseFragment() {

    private lateinit var binding: FragmentSplashBinding

    init {
        hasToolbarUpdate = true
        shouldShowActionBar = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val motionLayout = view as? MotionLayout
        motionLayout?.addTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                navController.navigate(R.id.action_splashFragment_to_newsFragment)
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
        })
    }
}