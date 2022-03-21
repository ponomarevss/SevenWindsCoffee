package ru.ponomarevss.sevenwindscoffee.model.entity.respond

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Point(
    val latitude: Float,
    val longitude: Float
): Parcelable
