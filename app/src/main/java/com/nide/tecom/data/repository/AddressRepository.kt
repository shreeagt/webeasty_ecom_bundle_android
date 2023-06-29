package com.nide.tecom.data.repository

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.model.AddressModel
import retrofit2.Response

interface AddressRepository  {

    suspend fun addAddress(userId: String, addressModel: AddressModel) : Response<ApiResult<Unit>>
    suspend fun updateAddress(addressId: String,address : AddressModel) : Response<ApiResult<Unit>>
    suspend fun getAddress(userId : String) : Response<ApiResult<List<AddressModel>>>
}