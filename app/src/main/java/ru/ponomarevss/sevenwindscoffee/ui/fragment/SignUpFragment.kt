package ru.ponomarevss.sevenwindscoffee.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.ponomarevss.sevenwindscoffee.databinding.FragmentSignUpBinding
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.SignUpViewModel

class SignUpFragment: Fragment(), BackButtonListener {
    companion object {
        fun newInstance() = SignUpFragment()
    }

    private var vb: FragmentSignUpBinding? = null
    private lateinit var vm: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSignUpBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this)[SignUpViewModel::class.java].apply {
            App.instance.appComponent.inject(this)
        }

        activity?.actionBar?.title = vm.actionBarTitle

        vb?.btnSignUp?.setOnClickListener {
//            vm.signUpPressed()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = vm.backPressed()
}