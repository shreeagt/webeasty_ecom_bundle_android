package com.nide.tecom.data.apiservice

import com.nide.tecom.core.response.ApiResponse
import com.nide.tecom.core.response.ApiResult
import com.nide.tecom.core.response.PageResponse
import com.nide.tecom.data.model.AddressModel
import com.nide.tecom.data.model.CartItemModel
import com.nide.tecom.data.model.CategoriModel
import com.nide.tecom.data.model.ShowProductModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface TcomApi {

    @GET("category")
    suspend fun allCategory(): Response<ApiResult<List<CategoriModel>>>

    @GET("wishlist")
    suspend fun getWishList(@Query("userid") userId: String): Response<ApiResult<List<ShowProductModel>>>

    @DELETE("wishlist")
    suspend fun deletewishlist(
        @Query("productid") productId: String,
        @Query("userid") userid: String
    )

    @POST("wishlist")
    suspend fun addIntoWishList()

    @GET("cart")
    suspend fun cartList(@Query("userid") userId: String): Response<ApiResult<List<CartItemModel>>>

    @POST("cart")

    suspend fun addTocart(@Query("productid") productId: String, @Query("userid") userId: String)

    @DELETE("cart")
    suspend fun removeCart(
        @Query("productid") productId: String,
        @Query("usrid") userId: String
    ): ResponseBody


    @GET("category")
    suspend fun getProduct(@Path("category") categoryId: String): PageResponse<ShowProductModel>

    @GET("search")
    suspend fun searchResult(@Query("q") query: String): PageResponse<ShowProductModel>

    @GET("address")
    suspend fun getAddress(@Query("user_id") userId: String): Response<ApiResult<List<AddressModel>>>

    @PUT("address")
    suspend fun updateAddress(
        @Field("address_id") addressId: String,
        @Field("address") address: AddressModel
    ): Response<ApiResult<Unit>>

    @POST("address")
    suspend fun addAddress(
        @Field("user_id") userId: String,
        @Field("address") address: AddressModel
    ):Response<ApiResult<Unit>>


}