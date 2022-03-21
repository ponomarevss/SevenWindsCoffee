package ru.ponomarevss.sevenwindscoffee.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.MenuItem

@Parcelize
data class OrderItem(
    var menuItem: MenuItem,
    var quantity: Int = 0
): Parcelable