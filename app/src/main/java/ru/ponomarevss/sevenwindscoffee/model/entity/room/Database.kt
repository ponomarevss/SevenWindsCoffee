package ru.ponomarevss.sevenwindscoffee.model.entity.room

import androidx.room.RoomDatabase
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token

@androidx.room.Database(
    entities = [
        Token::class
//        RoomToken::class
    ],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract val tokenDao: TokenDao

    companion object {
        const val DB_NAME = "database.db"
    }
}