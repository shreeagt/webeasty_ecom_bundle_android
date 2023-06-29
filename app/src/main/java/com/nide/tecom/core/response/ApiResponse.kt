package com.nide.tecom.core.response


sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    object Loading : ApiResponse<Nothing>()
    data class Error<T>(val message: String, val code: Int) : ApiResponse<T>()
}