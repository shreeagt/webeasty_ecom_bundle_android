package com.nide.tecom.data.repository

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.model.CategoriModel
import retrofit2.Response

interface CategoryRepository {

    suspend fun allCategory(): Response<ApiResult<List<CategoriModel>>>

}