package com.nide.tecom.domain.repositoryimpl

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.CartItemModel
import com.nide.tecom.data.repository.CartRepository
import retrofit2.Response

class CartRepositoryImpl(private val api: TcomApi) : CartRepository {

    override suspend fun allCartList(userId: String): Response<ApiResult<List<CartItemModel>>> {
        return api.cartList(userId)
    }
}