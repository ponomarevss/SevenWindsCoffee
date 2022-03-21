package ru.ponomarevss.sevenwindscoffee.model.entity.respond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val id: Int,
    val name: String,
    val imageURL: String,
    val price: Int
): Parcelable
