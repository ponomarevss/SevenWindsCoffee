package ru.ponomarevss.sevenwindscoffee.model.api

import retrofit2.Call
import retrofit2.http.*
import ru.ponomarevss.sevenwindscoffee.model.entity.User
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.MenuItem
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token

interface IDataSource {

    @POST("auth/login")
    suspend fun login(@Body user: User): Token

    @POST("auth/register")
    fun register(
        @Body() user: User
    ): Call<Token>

    @GET("locations")
    suspend fun locations(
        @Header("Authorization") authHeader: String
    ): List<Location>

    @GET("location/{id}/menu")
    suspend fun menu(
        @Header("Authorization") authHeader: String,
        @Path("id") id: Int
    ): List<MenuItem>
}