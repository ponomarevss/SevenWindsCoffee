package ru.ponomarevss.sevenwindscoffee.di.module

import dagger.Module
import dagger.Provides
import ru.ponomarevss.sevenwindscoffee.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app
}