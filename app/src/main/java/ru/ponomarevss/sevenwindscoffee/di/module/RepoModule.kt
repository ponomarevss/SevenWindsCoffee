package ru.ponomarevss.sevenwindscoffee.di.module

import dagger.Module
import dagger.Provides
import ru.ponomarevss.sevenwindscoffee.model.api.IDataSource
import ru.ponomarevss.sevenwindscoffee.model.repo.IRepo
import ru.ponomarevss.sevenwindscoffee.model.repo.RetrofitRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun repo(api: IDataSource): IRepo = RetrofitRepo(api)
}