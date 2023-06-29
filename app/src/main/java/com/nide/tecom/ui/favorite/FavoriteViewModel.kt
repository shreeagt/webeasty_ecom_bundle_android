package com.nide.tecom.ui.favorite

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.UiState
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.data.repository.WishListRepository
import com.nide.tecom.util.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val wishListRepository: WishListRepository
) : BaseViewModel() {


    private val _wishlist = MutableStateFlow<List<ShowProductModel>>(emptyList())
    val wishlist = _wishlist.asStateFlow()

    private val userId = ""


    init {
        getWishList()
    }

    private fun getWishList() = viewModelScope.launch {
        try {
            changeUiState(UiState.Loading)
            val response = wishListRepository.getWishList(userId)
            if (response.isSuccessful) {
                val result = response.body()
                Timber.i("result " + result.toString())
                if (result?.responseCode != 200) {
                    changeUiState(UiState.Error)
                    setErrorMessage(Const.ERROR_MSG_UNKNOWN)
                    return@launch
                }
                _wishlist.emit(result.result!!)
                changeUiState(UiState.Success)
            } else {
                changeUiState(UiState.Error)
                setErrorMessage(Const.ERROR_MSG_NETWORK_FAILER)
                Timber.i("Error in network call")
            }
        } catch (e: Exception) {
            setErrorMessage(Const.ERROR_MSG_SOMTHING_WRONG)
            changeUiState(UiState.Error)
            Timber.i(e.message)
        }

    }


}