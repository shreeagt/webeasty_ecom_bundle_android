package com.nide.tecom.domain.repositoryimpl

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.data.repository.WishListRepository
import retrofit2.Response

class WishListRepositoryImpl(private val api : TcomApi) : WishListRepository {

    override suspend fun getWishList(userId: String): Response<ApiResult<List<ShowProductModel>>> {
       return api.getWishList(userId)
    }
}