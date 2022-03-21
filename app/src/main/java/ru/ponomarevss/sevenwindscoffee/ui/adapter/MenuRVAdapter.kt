package ru.ponomarevss.sevenwindscoffee.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.ponomarevss.sevenwindscoffee.databinding.ItemCoffeeBinding
import ru.ponomarevss.sevenwindscoffee.databinding.ItemLocationBinding
import ru.ponomarevss.sevenwindscoffee.model.image.IImageLoader
import ru.ponomarevss.sevenwindscoffee.model.view.LocationItemView
import ru.ponomarevss.sevenwindscoffee.model.view.MenuItemView
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.LocationsViewModel
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.MenuViewModel

class MenuRVAdapter(val model: MenuViewModel.MenuItemsListViewModel, val imageLoader: IImageLoader<ImageView>): RecyclerView.Adapter<MenuRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCoffeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener {
                model.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = model.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = model.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemCoffeeBinding) : RecyclerView.ViewHolder(vb.root), MenuItemView {
        override var pos = -1

        override fun loadImage(url: String) = with(vb) {
            imageLoader.loadInto(url, image)
        }

        override fun setName(text: String) = with(vb) { tvName.text = text }

        override fun setPrice(text: String) = with(vb){ price.text = text }

        override fun setQuantity(text: String) = with(vb){ quantity.text = text }

        override fun setPlusClickListener(listener: View.OnClickListener) {
            vb.plus.setOnClickListener(listener)
        }
    }
}