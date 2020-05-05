package com.example.recyclerviewmvvmtodagger.di.subcomponent

import com.example.recyclerviewmvvmtodagger.di.module.MoviesViewModelModule
import com.example.recyclerviewmvvmtodagger.di.module.ViewModelFactoryModule
import com.example.recyclerviewmvvmtodagger.di.scope.FragmentScope
import com.example.recyclerviewmvvmtodagger.ui.movies.MoviesFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        MoviesViewModelModule::class
    ]
)
interface MoviesFragmentComponent {
    fun inject(moviesFragment: MoviesFragment)
}