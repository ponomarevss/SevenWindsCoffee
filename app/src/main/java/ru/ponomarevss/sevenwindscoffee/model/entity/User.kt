package ru.ponomarevss.sevenwindscoffee.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var login: String,
    var password: String
): Parcelable