package com.nide.tecom.domain.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.SearchPaging
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.ShowProductModel
import com.nide.tecom.data.repository.SearchRepository
import retrofit2.Response

class SearchRepositoryImpl(private val api: TcomApi) : SearchRepository {

    override suspend fun onSearch(query: String) = Pager(
        config = PagingConfig(
            pageSize = 10,
            maxSize = 20,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            SearchPaging(api, query)
        }
    ).flow
}