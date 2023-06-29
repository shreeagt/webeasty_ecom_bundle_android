package com.nide.tecom.domain.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nide.tecom.data.LocalPreference
import com.nide.tecom.data.apiservice.TcomApi
import com.nide.tecom.data.local.dao.SearchDao
import com.nide.tecom.data.local.database.SearchDatabase
import com.nide.tecom.data.repository.RecentSearchRepository
import com.nide.tecom.domain.repositoryimpl.RecentSearchRepositoryImpl
import com.nide.tecom.util.Const.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AplicationModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTcomApi(retrofit: Retrofit): TcomApi {
        return retrofit.create(TcomApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): SearchDatabase {
        return Room.databaseBuilder(
            context,
            SearchDatabase::class.java,
            "SearchDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSearchDao(db: SearchDatabase): SearchDao {
        return db.searchDao()
    }

    @Provides
    @Singleton
    fun provideRecentSearchRepository(dao: SearchDao): RecentSearchRepository {

        return RecentSearchRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideLocalDataStore(@ApplicationContext context: Context): LocalPreference {
        return LocalPreference(context)
    }

}