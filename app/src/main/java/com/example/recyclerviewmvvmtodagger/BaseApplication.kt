package com.example.recyclerviewmvvmtodagger

import android.app.Application
import com.example.recyclerviewmvvmtodagger.di.component.AppComponent
import com.example.recyclerviewmvvmtodagger.di.component.DaggerAppComponent
import com.example.recyclerviewmvvmtodagger.di.module.AppModule

@Suppress("DEPRECATION")
class BaseApplication : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger()  = DaggerAppComponent.builder()
        .appModule(AppModule())
        .build()
}