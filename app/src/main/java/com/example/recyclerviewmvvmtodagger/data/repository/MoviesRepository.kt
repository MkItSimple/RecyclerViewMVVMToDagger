package com.example.recyclerviewmvvmtodagger.data.repository

import com.example.recyclerviewmvvmtodagger.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}