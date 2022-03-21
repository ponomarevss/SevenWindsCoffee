package ru.ponomarevss.sevenwindscoffee.di

import dagger.Component
import ru.ponomarevss.sevenwindscoffee.di.module.*
import ru.ponomarevss.sevenwindscoffee.ui.activity.MainActivity
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)
    fun inject(signInViewModel: SignInViewModel)
    fun inject(signUpViewModel: SignUpViewModel)
    fun inject(locationsViewModel: LocationsViewModel)
    fun inject(menuViewModel: MenuViewModel)
    fun inject(orderViewModel: OrderViewModel)
}