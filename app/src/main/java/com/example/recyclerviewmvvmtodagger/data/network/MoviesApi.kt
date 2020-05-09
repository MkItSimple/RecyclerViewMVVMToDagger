package com.example.recyclerviewmvvmtodagger.data.network

import com.example.recyclerviewmvvmtodagger.data.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("movies")
    suspend fun getMovies() : Response<List<Movie>>
}