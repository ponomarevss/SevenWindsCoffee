package ru.ponomarevss.sevenwindscoffee.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import ru.ponomarevss.sevenwindscoffee.ui.fragment.*

class AndroidScreens : IScreens {
    override fun signUp(): Screen = FragmentScreen { SignUpFragment.newInstance() }

    override fun signIn(): Screen = FragmentScreen { SignInFragment.newInstance() }

    override fun locations(token: String): Screen = FragmentScreen { LocationsFragment.newInstance(token) }

    override fun menu(token: String, location: Location): Screen  = FragmentScreen { MenuFragment.newInstance(token, location) }

    override fun order(): Screen  = FragmentScreen { OrderFragment.newInstance() }
}