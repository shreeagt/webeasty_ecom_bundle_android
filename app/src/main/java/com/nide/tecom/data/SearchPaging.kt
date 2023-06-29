package com.nide.tecom.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.ShowProductModel

class SearchPaging constructor(
    private val api: TcomApi,
    private val query: String
) : PagingSource<Int, ShowProductModel>() {


    override fun getRefreshKey(state: PagingState<Int, ShowProductModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShowProductModel> {
        return try {
            val pageNo = params.key ?: 1
            val response = api.searchResult(query)
            LoadResult.Page(
                data = response.result,
                prevKey = if (pageNo == 1) null else pageNo - 1,
                nextKey = if (pageNo == response.totalPages) null else pageNo + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}