package mezzari.torres.lucas.motion_layout_test.adapter.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mezzari.torres.lucas.motion_layout_test.databinding.RowSeasonEntryBinding

class SeasonAdapter(context: Context): RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder(RowSeasonEntryBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    data class SeasonViewHolder(val binding: RowSeasonEntryBinding) :
        RecyclerView.ViewHolder(binding.root)
}