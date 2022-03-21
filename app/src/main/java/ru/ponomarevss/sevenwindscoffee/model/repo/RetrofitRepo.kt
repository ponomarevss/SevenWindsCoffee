package ru.ponomarevss.sevenwindscoffee.model.repo

import kotlinx.coroutines.withTimeout
import ru.ponomarevss.sevenwindscoffee.model.api.IDataSource
import ru.ponomarevss.sevenwindscoffee.model.entity.User
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.MenuItem

class RetrofitRepo(val api: IDataSource) : IRepo {
    companion object{
        private const val BEARER = "Bearer "
    }

    override suspend fun refreshToken(user: User): String {
        try {
            val result = withTimeout(5_000) {
                api.login(user)
            }
            return result.string
        } catch (e: Throwable) {
            throw TokenRefreshError("Unable to refresh token", e)
        }
    }

    override suspend fun getLocations(token: String): List<Location> {
        try {
            val result = withTimeout(5_000) {
                api.locations(BEARER + token)
            }
            return result
        } catch (e: Throwable) {
            throw LocationsFetchError("Unable to fetch locations", e)
        }
    }

    override suspend fun getMenu(token: String, id: Int): List<MenuItem> {
        try {
            val result = withTimeout(5_000) {
                api.menu(BEARER + token, id)
            }
            return result
        } catch (e: Throwable) {
            throw MenuFetchError("Unable to fetch menu", e)
        }
    }
}