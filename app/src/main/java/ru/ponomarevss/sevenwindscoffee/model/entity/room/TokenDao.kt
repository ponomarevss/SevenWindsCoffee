package ru.ponomarevss.sevenwindscoffee.model.entity.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token

@Dao
interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(token: Token)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(roomToken: RoomToken)

    @get:Query("SELECT * FROM Token WHERE id = 0")
    val roomTokenLiveData: LiveData<Token?>

//    @get:Query("SELECT * FROM RoomToken WHERE id = 0")
//    val roomTokenLiveData: LiveData<RoomToken?>

//    @Query("SELECT * FROM RoomToken WHERE id = 0")
//    suspend fun select(): RoomToken?
}