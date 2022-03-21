package ru.ponomarevss.sevenwindscoffee.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.runBlocking
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import ru.ponomarevss.sevenwindscoffee.model.repo.IRepo
import ru.ponomarevss.sevenwindscoffee.model.view.LocationItemView
import javax.inject.Inject

class LocationsViewModel : ViewModel() {
    companion object {
        private const val TITLE = "Ближайшие кофейни"
    }

    @Inject lateinit var repo: IRepo
    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    inner class LocationsListViewModel {
        val locations = mutableListOf<Location>()
        var itemClickListener: ((LocationItemView) -> Unit)? = null

        fun bindView(view: LocationItemView) {
            val location = locations[view.pos]
            view.setName(location.name)
        }

        fun getCount() = locations.size
    }

    val actionBarTitle = TITLE
    lateinit var token: String
    val locationsListViewModel = LocationsListViewModel()

    fun setItemClickListener() {
        locationsListViewModel.itemClickListener = {
            val location = locationsListViewModel.locations[it.pos]
            router.navigateTo(screens.menu(token, location))
        }
    }

    fun loadData() {
        locationsListViewModel.locations.clear()
        runBlocking {
            locationsListViewModel.locations.addAll(
                repo.getLocations(token)
            )
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}