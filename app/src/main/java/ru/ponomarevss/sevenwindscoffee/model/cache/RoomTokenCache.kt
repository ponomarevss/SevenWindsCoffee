package ru.ponomarevss.sevenwindscoffee.model.cache

import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token
import ru.ponomarevss.sevenwindscoffee.model.entity.room.Database

class RoomTokenCache(val db: Database) : ITokenCache {

    override suspend fun putToken(token: Token) = db.tokenDao.insert(token)

//    override suspend fun putToken(token: Token) = db.tokenDao.insert(
//        RoomToken(
//            authHeader = "Bearer ${token.string}",
//            expiresIn = System.currentTimeMillis() + token.tokenLifetime
//        )
//    )

//    override suspend fun getRoomToken(): RoomToken? = db.tokenDao.
}