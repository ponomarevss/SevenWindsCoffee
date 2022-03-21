package ru.ponomarevss.sevenwindscoffee.model.repo

interface IRefreshTokenCallback {
    fun onCompleted()
    fun onError(e: Throwable)
}