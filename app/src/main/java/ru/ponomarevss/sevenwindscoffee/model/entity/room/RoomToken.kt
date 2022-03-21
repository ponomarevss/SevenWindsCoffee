package ru.ponomarevss.sevenwindscoffee.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomToken(
    @PrimaryKey var id: Int = 0,
                var authHeader: String,
                var expiresIn: Long
)
