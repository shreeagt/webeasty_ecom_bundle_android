package com.nide.tecom.core.response

data class ApiResult<T>(
    val responseCode: Int,
    val result : T?
) {

}