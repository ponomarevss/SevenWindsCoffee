package ru.ponomarevss.sevenwindscoffee.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.runBlocking
import ru.ponomarevss.sevenwindscoffee.model.entity.User
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import ru.ponomarevss.sevenwindscoffee.model.repo.IRepo
import javax.inject.Inject

class SignInViewModel : ViewModel() {
    companion object {
        private const val TITLE = "Вход"
    }

    @Inject lateinit var repo: IRepo
    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    val actionBarTitle = TITLE
    var user = User("", "")
    lateinit var token: String

    fun refreshToken() {
        runBlocking {
            token = repo.refreshToken(user)
        }
    }

    fun loginChanged(l: String) = with(user) { login = l }

    fun passwordChanged(p: String) = with(user) { password = p }

    fun signInPressed() {
        refreshToken()
        router.navigateTo(screens.locations(token))
    }

    fun signUpPressed() = router.navigateTo(screens.signUp())

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}