package com.nide.tecom.data.repository


import androidx.paging.PagingData
import com.nide.tecom.data.model.ShowProductModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProduct(categoryId : String) : Flow<PagingData<ShowProductModel>>

}