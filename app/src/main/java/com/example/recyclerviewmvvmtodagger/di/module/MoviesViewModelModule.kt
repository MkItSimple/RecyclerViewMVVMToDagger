package com.example.recyclerviewmvvmtodagger.di.module

import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvmtodagger.ui.movies.MoviesViewModel
import com.example.recyclerviewmvvmtodagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MoviesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    internal abstract fun bindPokemonListViewModel(viewModel: MoviesViewModel): ViewModel
}