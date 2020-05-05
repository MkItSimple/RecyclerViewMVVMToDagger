package com.example.recyclerviewmvvmtodagger.di.module

import com.example.recyclerviewmvvmtodagger.data.network.MoviesApi
import com.example.recyclerviewmvvmtodagger.data.repository.MoviesRepository
import com.example.recyclerviewmvvmtodagger.di.scope.AppScope
import com.example.recyclerviewmvvmtodagger.domain.MovieUsecase
import com.example.recyclerviewmvvmtodagger.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    // Profile Retofit
    @AppScope
    @Provides
    fun provideRetrofit() : MoviesApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MoviesApi::class.java)

    // Provide Repository
    @AppScope
    @Provides
    fun provideRepository(api: MoviesApi) = MoviesRepository(api)

}