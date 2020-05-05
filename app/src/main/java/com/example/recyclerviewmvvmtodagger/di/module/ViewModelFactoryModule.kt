package com.example.recyclerviewmvvmtodagger.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewmvvmtodagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}