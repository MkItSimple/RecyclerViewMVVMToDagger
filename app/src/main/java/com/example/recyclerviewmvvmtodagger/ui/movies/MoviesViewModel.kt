package com.example.recyclerviewmvvmtodagger.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvmtodagger.data.models.Movie
import com.example.recyclerviewmvvmtodagger.data.repository.MoviesRepository
import com.example.recyclerviewmvvmtodagger.utils.Coroutines
import kotlinx.coroutines.Job
import javax.inject.Inject

class MoviesViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: MoviesRepository

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()            // when job executed then cancel it to save memory leaks
    }
}
