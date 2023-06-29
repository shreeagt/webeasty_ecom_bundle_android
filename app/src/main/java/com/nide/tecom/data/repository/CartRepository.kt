package com.nide.tecom.data.repository

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.model.CartItemModel
import retrofit2.Response

interface CartRepository {

    suspend fun allCartList(userId : String) : Response<ApiResult<List<CartItemModel>>>



}