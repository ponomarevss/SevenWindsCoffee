package ru.ponomarevss.sevenwindscoffee.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ponomarevss.sevenwindscoffee.databinding.FragmentMenuBinding
import ru.ponomarevss.sevenwindscoffee.model.entity.respond.Location
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.adapter.MenuRVAdapter
import ru.ponomarevss.sevenwindscoffee.ui.image.GlideImageLoader
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.MenuViewModel

class MenuFragment: Fragment(), BackButtonListener {
    companion object {
        private const val TOKEN_ARG = "token"
        private const val LOCATION_ARG = "location"

        fun newInstance(token: String, location: Location) = MenuFragment().apply {
            arguments = Bundle().apply {
                putString(TOKEN_ARG, token)
                putParcelable(LOCATION_ARG, location)
            }
        }
    }

    private var vb: FragmentMenuBinding? = null
    val vm: MenuViewModel by viewModels()
    lateinit var adapter: MenuRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMenuBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.apply {
            token = arguments?.getString(TOKEN_ARG).toString()
            location = arguments?.getParcelable<Location>(LOCATION_ARG) as Location
            App.instance.appComponent.inject(this)
        }
        initView()
        vm.loadData()
    }

    private fun initView() {
        activity?.actionBar?.title = vm.actionBarTitle
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

        vb?.rvCoffee?.layoutManager = GridLayoutManager(context, 2)
        adapter = MenuRVAdapter(vm.menuItemsListViewModel, GlideImageLoader())
        vb?.rvCoffee?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = vm.backPressed()
}