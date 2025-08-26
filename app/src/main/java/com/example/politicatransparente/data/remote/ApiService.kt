package com.example.politicatransparente.data.remote

import com.example.politicatransparente.data.remote.dto.DeputadoResumoResponse
import retrofit2.http.GET

interface ApiService {

    @GET("deputados")
    suspend fun getDeputados(): DeputadoResumoResponse
}