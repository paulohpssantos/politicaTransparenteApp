package com.example.politicatransparente.data.repository

import com.example.politicatransparente.data.local.dao.DeputadoResumoDao
import com.example.politicatransparente.data.remote.ApiService
import com.example.politicatransparente.domain.mapper.toDomain
import com.example.politicatransparente.domain.mapper.toEntity
import com.example.politicatransparente.domain.model.DeputadoResumo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DeputadoResumoRepository (
    private val api: ApiService,
    private val dao: DeputadoResumoDao
) {

    fun getResumos(): Flow<List<DeputadoResumo>>{
        return dao.getAllDeputados().map { list ->
            list.map { it.toDomain() }
        }
    }

    suspend fun refreshResumos(){
        val response = api.getDeputados()
        val entities = response.dados.map { it.toEntity() }
        dao.insertAll(entities)
    }

}