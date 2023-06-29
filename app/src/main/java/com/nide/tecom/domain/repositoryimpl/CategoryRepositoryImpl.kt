package com.nide.tecom.domain.repositoryimpl

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.CategoriModel
import com.nide.tecom.data.repository.CategoryRepository
import retrofit2.Response

class CategoryRepositoryImpl(private val api: TcomApi) : CategoryRepository {

    override suspend fun allCategory(): Response<ApiResult<List<CategoriModel>>> {
        return api.allCategory()
    }
}