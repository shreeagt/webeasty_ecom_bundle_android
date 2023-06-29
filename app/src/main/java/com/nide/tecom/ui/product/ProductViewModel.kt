package com.nide.tecom.ui.product

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.UiState
import com.nide.tecom.data.model.ProductModel
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.data.repository.ProductRepository
import com.nide.tecom.data.repository.SearchRepository
import com.nide.tecom.domain.repositoryimpl.ProductRepositoryImpl
import com.nide.tecom.util.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepo: ProductRepository,
    private val searchRepo: SearchRepository
) : BaseViewModel() {

    private var productList: StateFlow<PagingData<ShowProductModel>?> = MutableStateFlow(null)

    val searchQuery = ""
    val categoryId = ""

    private fun getSearchResult() = viewModelScope.launch {

        try {
            changeUiState(UiState.Loading)
            productList = searchRepo.onSearch(searchQuery)
                .cachedIn(viewModelScope)
                .stateIn(
                    viewModelScope,
                    started = SharingStarted.WhileSubscribed(),
                    null
                )

        } catch (e: Exception) {
            changeUiState(UiState.Error)
            setErrorMessage(Const.ERROR_MSG_SOMTHING_WRONG)
        }
    }


    private fun getCategoryProduct() = viewModelScope.launch {

        try {
            changeUiState(UiState.Loading)
            productList = productRepo.getProduct(categoryId)
                .cachedIn(viewModelScope)
                .stateIn(
                    viewModelScope,
                    started = SharingStarted.WhileSubscribed(),
                    null
                )

        } catch (e: Exception) {
            changeUiState(UiState.Error)
            setErrorMessage(Const.ERROR_MSG_SOMTHING_WRONG)
        }

    }


}