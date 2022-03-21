package ru.ponomarevss.sevenwindscoffee.model.cache

import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token

interface ITokenCache {
    suspend fun putToken(token: Token)
//    suspend fun getRoomToken(): RoomToken?
}