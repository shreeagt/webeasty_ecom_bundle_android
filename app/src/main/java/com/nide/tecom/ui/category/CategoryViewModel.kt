package com.nide.tecom.ui.category

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nide.tecom.core.base.BaseViewModel
import com.nide.tecom.core.state.UiState
import com.nide.tecom.data.model.CategoriModel
import com.nide.tecom.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val catRep: CategoryRepository
) : BaseViewModel() {

    private val _categoryList = MutableStateFlow<List<CategoriModel>>(emptyList())
    val categoryList = _categoryList.asStateFlow()

    init {
        getCategory()
    }

    private fun getCategory() = viewModelScope.launch {
        try {
            changeUiState(UiState.Loading)
            val response = catRep.allCategory()

            if (response.isSuccessful) {
                val data = response.body()
                if (data?.responseCode != 200) {
                   changeUiState(UiState.Error)
                    return@launch
                }
                _categoryList.emit(data.result!!)
               changeUiState(UiState.Success)
            } else {
               changeUiState(UiState.Error)
            }
        } catch (e: Exception) {
            changeUiState(UiState.Error)
        }
    }


}