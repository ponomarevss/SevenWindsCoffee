package ru.ponomarevss.sevenwindscoffee.model.entity.respond

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Token(
    @SerializedName("token") val string: String,
    @PrimaryKey var id: Int = 0
//    val tokenLifetime: Long
): Parcelable