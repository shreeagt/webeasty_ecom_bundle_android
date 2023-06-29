package com.nide.tecom.domain.di


import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.repository.*
import com.nide.tecom.domain.repositoryimpl.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideCategoryRepository(api: TcomApi): CategoryRepository {
        return CategoryRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideWishList(api: TcomApi): WishListRepository {
        return WishListRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCartRepository(api: TcomApi): CartRepository {
        return CartRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSearchRepository(api: TcomApi): SearchRepository {
        return SearchRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: TcomApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAddressRepository(api: TcomApi): AddressRepository {
        return AddressRepositoryImpl(api)
    }


}