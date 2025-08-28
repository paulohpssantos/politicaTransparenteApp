package com.example.politicatransparente.data.remote

import com.example.politicatransparente.data.remote.dto.dadosdeputado.DadosDeputadoResponse
import com.example.politicatransparente.data.remote.dto.resumodeputado.ResumoDeputadoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("deputados")
    suspend fun getDeputados(): ResumoDeputadoResponse

    @GET("deputados/{id}")
    suspend fun getDeputadoPorId(@Path("id") id: Int): DadosDeputadoResponse
}