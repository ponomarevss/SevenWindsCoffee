package ru.ponomarevss.sevenwindscoffee.model.repo

class TokenRefreshError(message: String, e: Throwable): Throwable(message, e)
class LocationsFetchError(message: String, e: Throwable): Throwable(message, e)
class MenuFetchError(message: String, e: Throwable): Throwable(message, e)