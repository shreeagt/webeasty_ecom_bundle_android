package com.nide.tecom.ui.login.login

import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : BaseViewModel() {


    private val _loginState = MutableStateFlow(LoginState.NOT_INITIALIZED)
    val loginState = _loginState.asStateFlow()



    fun logIn(email : String, pass : String) = viewModelScope.launch{

        _loginState.emit(
            LoginState.SUCCESS
        )

    }


}