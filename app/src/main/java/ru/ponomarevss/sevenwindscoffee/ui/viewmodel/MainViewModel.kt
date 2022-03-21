package ru.ponomarevss.sevenwindscoffee.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    fun setHomeFragment() = router.navigateTo(screens.signIn())

    fun backPressed() = router.exit()
}