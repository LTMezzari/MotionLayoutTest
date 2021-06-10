package mezzari.torres.lucas.motion_layout_test.adapter.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mezzari.torres.lucas.motion_layout_test.archive.format
import mezzari.torres.lucas.motion_layout_test.archive.toDate
import mezzari.torres.lucas.motion_layout_test.databinding.RowSeasonEntryBinding
import mezzari.torres.lucas.motion_layout_test.model.Anime

/**
 * @author Lucas T. Mezzari
 * @author lucas.mezzari@digitalbusiness.com.br
 * @since 10/06/21
 */
class SeasonAdapter(context: Context): RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var _items: ArrayList<Anime> = ArrayList()
    var items: List<Anime> set(value) {
        _items = ArrayList(value)
        notifyDataSetChanged()
    } get() = _items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        return SeasonViewHolder(RowSeasonEntryBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        val item = _items[position]
        holder.binding.apply {
            tvTitle.text = item.title
            tvDate.text = item.airingStart.toDate()?.format("dd/MM/yyyy") ?: ""
            tvDescription.text = item.synopsis

            Glide.with(root).load(item.imageUrl).into(ivCover)
        }
    }

    override fun getItemCount(): Int = items.size

    data class SeasonViewHolder(val binding: RowSeasonEntryBinding) :
        RecyclerView.ViewHolder(binding.root)
}