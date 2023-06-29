package com.nide.tecom.data.repository

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.model.ShowProductModel
import retrofit2.Response

interface WishListRepository {

    suspend fun getWishList(userId : String) : Response<ApiResult<List<ShowProductModel>>>

}