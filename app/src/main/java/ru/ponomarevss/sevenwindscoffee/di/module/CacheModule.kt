package ru.ponomarevss.sevenwindscoffee.di.module

import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ponomarevss.sevenwindscoffee.model.api.IDataSource
import ru.ponomarevss.sevenwindscoffee.model.cache.ITokenCache
import ru.ponomarevss.sevenwindscoffee.model.cache.RoomTokenCache
import ru.ponomarevss.sevenwindscoffee.model.entity.room.Database
import ru.ponomarevss.sevenwindscoffee.ui.App
import javax.inject.Named
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(
        app,
        Database::class.java,
        Database.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun tokenCache(db: Database): ITokenCache = RoomTokenCache(db)

}