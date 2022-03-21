package ru.ponomarevss.sevenwindscoffee.model.entity.respond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val id: Int,
    val name: String,
    val point: Point
): Parcelable
