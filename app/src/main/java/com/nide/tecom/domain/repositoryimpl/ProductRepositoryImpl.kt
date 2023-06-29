package com.nide.tecom.domain.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.ProductPaging
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.data.repository.ProductRepository
import retrofit2.Response

class ProductRepositoryImpl(private val api: TcomApi) : ProductRepository {

    override suspend fun getProduct(categoryId: String) = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 20,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            ProductPaging(
                api,
                categoryId
            )
        }
    ).flow
}