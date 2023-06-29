package com.nide.tecom.data.repository

import androidx.paging.PagingData
import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.model.ShowProductModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SearchRepository {

    suspend fun onSearch(query: String): Flow<PagingData<ShowProductModel>>

}