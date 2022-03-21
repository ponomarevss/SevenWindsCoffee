package ru.ponomarevss.sevenwindscoffee.model.repo

import ru.ponomarevss.sevenwindscoffee.model.entity.User
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.MenuItem

interface IRepo {
    suspend fun refreshToken(user: User): String
    suspend fun getLocations(token: String): List<Location>
    suspend fun getMenu(token: String, id: Int): List<MenuItem>
}