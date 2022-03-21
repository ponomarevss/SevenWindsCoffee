package ru.ponomarevss.sevenwindscoffee.model.navigation

import com.github.terrakok.cicerone.Screen
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location

interface IScreens {
    fun signUp(): Screen
    fun signIn(): Screen
    fun locations(token: String): Screen
    fun menu(token: String, location: Location): Screen
    fun order(): Screen
}