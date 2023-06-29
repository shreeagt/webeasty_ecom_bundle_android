package com.nide.tecom.ui.login.register

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
import com.nide.tecom.databinding.FragmentRegisterBinding
import com.nide.tecom.ui.MainActivity
import com.nide.tecom.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_register

    private val viewModel: RegisterViewModel by viewModels()

    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner


        }

        initClicks()
        observeData()


    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentRegisterBinding
        get() = DataBindingUtil::inflate


    private fun initClicks() = binding?.apply {
        btnRegister.setOnClickListener {

            if (textInputEmail.editText!!.validEmail()
                && textInputPhone.editText!!.validMobile()
                && textInputPassword.editText!!.validPass()
                && textInputConPassword.editText!!.confirmPass(textInputPassword.editText!!)
            ) {
                val email = textInputEmail.editText!!.text.toString()
                val mobile = textInputPhone.editText!!.text.toString()
                val pass = textInputPassword.editText!!.text.toString()
                viewModel.register(email, pass, mobile)
            }


        }


    }

    private fun observeData() {
        observeFlow(viewModel.errorMessage, ::showSnack)
        observeFlow(viewModel.registerState) {
            when (it) {
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