package ru.ponomarevss.sevenwindscoffee.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import javax.inject.Inject

class OrderViewModel : ViewModel() {
    companion object {
        private const val TITLE = "Ваш заказ"
    }

    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    val actionBarTitle = TITLE

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}