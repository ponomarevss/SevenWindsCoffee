package ru.ponomarevss.sevenwindscoffee.model.view

import android.view.View

interface MenuItemView: IItemView {
    fun loadImage(url: String)
    fun setName(text: String)
    fun setPrice(text: String)
    fun setQuantity(text: String)
    fun setPlusClickListener(listener: View.OnClickListener)

}