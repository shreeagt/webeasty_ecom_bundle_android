package com.nide.tecom.ui.cart

import androidx.compose.runtime.MutableState
import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.UiState
import com.nide.tecom.data.model.CartItemModel
import com.nide.tecom.data.repository.CartRepository
import com.nide.tecom.util.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepo: CartRepository
) : BaseViewModel() {


    private val _cartList = MutableStateFlow<List<CartItemModel>>(emptyList())
    val cartList = _cartList.asStateFlow()

    private val userId = ""

    init {
        getCatList()
    }


    private fun getCatList() = viewModelScope.launch {
        try {
            changeUiState(UiState.Loading)
            val response = cartRepo.allCartList(userId)
            if (response.isSuccessful) {
                val result = response.body()
                if (result?.responseCode != 200) {
                    changeUiState(UiState.Error)
                    setErrorMessage(Const.ERROR_MSG_SOMTHING_WRONG)
                    return@launch
                }
                _cartList.emit(result.result!!)
                changeUiState(UiState.Success)
            } else {
                setErrorMessage(Const.ERROR_MSG_NETWORK_FAILER)
                changeUiState(UiState.Error)
            }

        } catch (e: Exception) {
            setErrorMessage(Const.ERROR_MSG_UNKNOWN)
            changeUiState(UiState.Error)
        }
    }



}