package com.nide.tecom.domain.repositoryimpl

import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.repository.AddressRepository
import retrofit2.Response
import javax.inject.Inject

class AddressRepositoryImpl  (private val api: TcomApi) : AddressRepository {

    override suspend fun addAddress(
        userId: String,
        addressModel: AddressModel
    ): Response<ApiResult<Unit>> {
        return api.addAddress(userId, addressModel)
    }

    override suspend fun updateAddress(
        addressId: String,
        address: AddressModel
    ): Response<ApiResult<Unit>> {
        return api.updateAddress(addressId, address)
    }

    override suspend fun getAddress(userId: String): Response<ApiResult<List<AddressModel>>> {
        return api.getAddress(userId)
    }
}