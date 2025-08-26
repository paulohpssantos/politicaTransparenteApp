package com.example.politicatransparente

import android.app.Application
import com.example.politicatransparente.di.databaseModule
import com.example.politicatransparente.di.networkModule
import com.example.politicatransparente.di.repositoryModule
import com.example.politicatransparente.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PoliticaTransparenteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PoliticaTransparenteApp)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}