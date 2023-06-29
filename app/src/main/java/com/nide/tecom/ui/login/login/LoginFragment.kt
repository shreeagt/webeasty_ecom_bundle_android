package com.nide.tecom.ui.login.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.core.state.LoginState
import com.nide.tecom.databinding.FragmentLoginBinding
import com.nide.tecom.ui.MainActivity
import com.nide.tecom.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_login


    private val viewModel: LoginViewModel by viewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        initClicks()
        observeData()
    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = DataBindingUtil::inflate


    private fun initClicks() = binding?.apply {
        btnLogin.setOnClickListener {

            if(textInputEmail.editText!!.validEmail() && textInputPassword.editText!!.validPass()){
                val email = textInputEmail.editText!!.text.toString()
                val pass = textInputPassword.editText!!.text.toString()
                viewModel.logIn(email,pass)
            }


        }


    }

    private fun observeData() {
        observeFlow(viewModel.errorMessage, ::showSnack)
        observeFlow(viewModel.loginState){
            when(it){
                LoginState.SUCCESS -> {
                    startNewActivity(MainActivity::class.java)
                }
                LoginState.FAILED -> {}
                LoginState.INVALID -> {}
                LoginState.NOT_INITIALIZED -> {}
            }
        }

    }


}