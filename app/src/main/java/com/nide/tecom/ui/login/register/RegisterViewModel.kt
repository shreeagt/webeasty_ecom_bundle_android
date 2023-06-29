package com.nide.tecom.ui.login.register

import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(

) : BaseViewModel() {

    private val _registerState = MutableStateFlow(LoginState.NOT_INITIALIZED)
    val registerState = _registerState.asStateFlow()



    fun register(email : String, pass : String,phone : String) = viewModelScope.launch{

        _registerState.emit(
            LoginState.SUCCESS
        )

    }


}