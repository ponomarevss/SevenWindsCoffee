package ru.ponomarevss.sevenwindscoffee.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ponomarevss.sevenwindscoffee.databinding.FragmentShopsBinding
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.adapter.LocationsRVAdapter
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.LocationsViewModel

class LocationsFragment: Fragment(), BackButtonListener {
    companion object {
        private const val TOKEN_ARG = "token"

        fun newInstance(token: String) = LocationsFragment().apply {
            arguments = Bundle().apply {
                putString(TOKEN_ARG, token)
            }
        }
    }

    private var vb: FragmentShopsBinding? = null
    val vm: LocationsViewModel by viewModels()
    lateinit var adapter: LocationsRVAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentShopsBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.apply {
            token = arguments?.getString(TOKEN_ARG).toString()
            App.instance.appComponent.inject(this)
        }
        initView()
        vm.setItemClickListener()
        vm.loadData()
    }

    private fun initView() {
        activity?.actionBar?.title = vm.actionBarTitle
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        activity?.actionBar?.setHomeButtonEnabled(true)

        vb?.rvLocations?.layoutManager = LinearLayoutManager(context)
        adapter = LocationsRVAdapter(vm.locationsListViewModel)
        vb?.rvLocations?.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            vm.backPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = vm.backPressed()
}