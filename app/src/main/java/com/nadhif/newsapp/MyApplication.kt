package com.nadhif.newsapp

import android.app.Application
import com.nadhif.core.di.databaseModule
import com.nadhif.core.di.networkModule
import com.nadhif.core.di.repositoryModule
import com.nadhif.newsapp.di.useCaseModule
import com.nadhif.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}