package mezzari.torres.lucas.motion_layout_test.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mezzari.torres.lucas.motion_layout_test.adapter.ui.SeasonAdapter
import mezzari.torres.lucas.motion_layout_test.databinding.FragmentNewsBinding
import mezzari.torres.lucas.motion_layout_test.generic.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Lucas T. Mezzari
 * @since 08/06/2021
 */
class NewsFragment: BaseFragment() {
    private lateinit var binding: FragmentNewsBinding

    private val viewModel: NewsViewModel by viewModel()

    private val adapter: SeasonAdapter by lazy {
        SeasonAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSubTitle.text = "Hello World"
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = this@NewsFragment.adapter
        }
        viewModel.apply {
            seasonList.observe(owner = viewLifecycleOwner) {
                adapter.items = it ?: arrayListOf()
            }
            loadSeason()
        }
    }
}