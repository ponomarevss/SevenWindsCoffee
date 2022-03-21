package ru.ponomarevss.sevenwindscoffee.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.runBlocking
import ru.ponomarevss.sevenwindscoffee.model.entity.OrderItem
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.MenuItem
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Token
import ru.ponomarevss.sevenwindscoffee.model.navigation.IScreens
import ru.ponomarevss.sevenwindscoffee.model.repo.IRepo
import ru.ponomarevss.sevenwindscoffee.model.view.LocationItemView
import ru.ponomarevss.sevenwindscoffee.model.view.MenuItemView
import javax.inject.Inject

class MenuViewModel : ViewModel() {
    companion object {
        private const val TITLE = "Меню"
    }

    @Inject lateinit var repo: IRepo
    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    inner class MenuItemsListViewModel {
        val menuItems = mutableListOf<MenuItem>()
        var itemClickListener: ((MenuItemView) -> Unit)? = null

        fun bindView(view: MenuItemView) {
            val menuItem = menuItems[view.pos]
            val orderItem = OrderItem(menuItem)
            view.loadImage(menuItem.imageURL)
            view.setName(menuItem.name)
            view.setPrice("${menuItem.price} руб")
            view.setQuantity(orderItem.quantity.toString())

            view.setPlusClickListener {
                ++orderItem.quantity
                var isExists = false
                order.map {
                    if (it.menuItem.id == orderItem.menuItem.id) {
                        it.quantity = orderItem.quantity
                        isExists = true
                    }
                }
                if (!isExists) {
                    order.add(orderItem)
                }
            }
        }

        fun getCount() = menuItems.size
    }

    val actionBarTitle = TITLE
    lateinit var token: String
    lateinit var location: Location
    val menuItemsListViewModel = MenuItemsListViewModel()
    var order = mutableListOf<OrderItem>()


    fun loadData() {
        menuItemsListViewModel.menuItems.clear()
        runBlocking {
            menuItemsListViewModel.menuItems.addAll(
                repo.getMenu(token, location.id)
            )
        }

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}