package com.example.recyclerviewmvvmtodagger.di.component

import com.example.recyclerviewmvvmtodagger.di.module.AppModule
import com.example.recyclerviewmvvmtodagger.di.scope.AppScope
import com.example.recyclerviewmvvmtodagger.di.subcomponent.MoviesFragmentComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun newMoviesFragmentComponent(): MoviesFragmentComponent
}