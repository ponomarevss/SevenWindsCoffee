package ru.ponomarevss.sevenwindscoffee.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ponomarevss.sevenwindscoffee.databinding.ItemLocationBinding
import ru.ponomarevss.sevenwindscoffee.model.view.LocationItemView
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.LocationsViewModel

class LocationsRVAdapter(val model: LocationsViewModel.LocationsListViewModel): RecyclerView.Adapter<LocationsRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                model.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = model.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = model.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemLocationBinding) : RecyclerView.ViewHolder(vb.root), LocationItemView {
        override var pos = -1

        override fun setName(text: String) = with(vb) { tvName.text = text }
    }
}