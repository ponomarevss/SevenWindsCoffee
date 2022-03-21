package ru.ponomarevss.sevenwindscoffee.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.ponomarevss.sevenwindscoffee.databinding.FragmentSignInBinding
import ru.ponomarevss.sevenwindscoffee.ui.App
import ru.ponomarevss.sevenwindscoffee.ui.BackButtonListener
import ru.ponomarevss.sevenwindscoffee.ui.viewmodel.SignInViewModel

class SignInFragment: Fragment(), BackButtonListener {
    companion object {
        fun newInstance() = SignInFragment()
    }

    private var vb: FragmentSignInBinding? = null
    val vm: SignInViewModel by viewModels()

    private val loginTextChangeListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) = vm.loginChanged(vb?.etMail?.text.toString())
    }
    private val passwordTextChangeListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) = vm.passwordChanged(vb?.etPassword?.text.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSignInBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.apply { App.instance.appComponent.inject(this) }
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = vm.backPressed()

    private fun initView(){
        activity?.actionBar?.title = vm.actionBarTitle

        vb?.etMail?.removeTextChangedListener(loginTextChangeListener)
        vb?.etPassword?.removeTextChangedListener(passwordTextChangeListener)

        vb?.btnSignIn?.setOnClickListener { vm.signInPressed() }
        vb?.tvSignUp?.setOnClickListener { vm.signUpPressed() }

        vb?.etMail?.addTextChangedListener(loginTextChangeListener)
        vb?.etPassword?.addTextChangedListener(passwordTextChangeListener)
    }

//    private fun refreshToken() {
//        vm.userLiveData.observe(this) {
//            it.login = vb?.etMail?.text.toString()
//            it.password = vb?.etPassword?.text.toString()
//        }
//        vm.refreshToken()
//    }
}