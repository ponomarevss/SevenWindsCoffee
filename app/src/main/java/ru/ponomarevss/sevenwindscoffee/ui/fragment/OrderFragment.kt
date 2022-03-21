package ru.ponomarevss.sevenwindscoffee.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.ponomarevss.sevenwindscoffee.databinding.FragmentOrderBinding
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.OrderViewModel

class OrderFragment: Fragment(), BackButtonListener {
    companion object {
        fun newInstance() = OrderFragment()
    }

    private var vb: FragmentOrderBinding? = null
    private lateinit var vm: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentOrderBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this)[OrderViewModel::class.java].apply {
            App.instance.appComponent.inject(this)
        }

        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        activity?.actionBar?.title = vm.actionBarTitle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = vm.backPressed()
}