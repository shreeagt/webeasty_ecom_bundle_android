package com.nide.tecom.core.state

sealed class UiState{

    object Loading : UiState()
    object Error : UiState()
    object Success : UiState()

}
