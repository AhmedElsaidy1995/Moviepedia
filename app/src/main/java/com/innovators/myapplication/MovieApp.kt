package com.innovators.myapplication

import android.app.Application
import com.innovators.myapplication.di.networkModule
import com.innovators.myapplication.di.repositoryModule
import com.innovators.myapplication.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(listOf(networkModule,viewModelModule,repositoryModule))
        }
    }
}