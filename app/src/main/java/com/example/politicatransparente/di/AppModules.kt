package com.example.politicatransparente.di

import androidx.room.Room
import com.example.politicatransparente.data.local.db.AppDatabase
import com.example.politicatransparente.data.remote.ApiService
import com.example.politicatransparente.data.repository.DadosDeputadoRepository
import com.example.politicatransparente.data.repository.ResumoDeputadoRepository
import com.example.politicatransparente.ui.viewmodel.ResumoDeputadoViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * módulo do Koin (AppModules.kt) para injetar ApiService, Room, os Repository e os ViewModel
 */

val networkModule = module() {
    single {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://dadosabertos.camara.leg.br/api/v2/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }
}

// Módulo de banco de dados (Room)
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "politicatransparente_db"
        ).build()
    }

    //Adiciona DAOs aqui
    single { get<AppDatabase>().resumoDeputadoDao() }
    single { get<AppDatabase>().dadosDeputadoDao() }
}

// Módulo de repositórios
val repositoryModule = module {
    single { ResumoDeputadoRepository(get(), get()) }
    single { DadosDeputadoRepository(get(), get()) }
}

//Módulo de viewmodels
val viewModelModule = module {
    viewModel { ResumoDeputadoViewModel(get()) }
}