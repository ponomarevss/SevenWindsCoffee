package ru.ponomarevss.sevenwindscoffee.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ponomarevss.sevenwindscoffee.model.api.IDataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    @Singleton
    fun baseUrl(): String = "http://185.244.172.108:8080/"

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .create()

    @Provides
    @Singleton
    fun okHttpClient() = OkHttpClient.Builder()
        .build()


    @Provides
    @Singleton
    fun api(@Named("baseUrl") baseUrl: String, okHttpClient: OkHttpClient, gson: Gson) : IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

}