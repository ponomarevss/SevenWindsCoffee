package ru.ponomarevss.sevenwindscoffee.ui

import android.app.Application
import ru.ponomarevss.sevenwindscoffee.di.AppComponent
import ru.ponomarevss.sevenwindscoffee.di.DaggerAppComponent
import ru.ponomarevss.sevenwindscoffee.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}