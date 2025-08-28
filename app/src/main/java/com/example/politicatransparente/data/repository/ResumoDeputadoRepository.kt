package com.example.politicatransparente.data.repository

import com.example.politicatransparente.data.local.dao.ResumoDeputadoDao
import com.example.politicatransparente.data.remote.ApiService
import com.example.politicatransparente.domain.mapper.toModel
import com.example.politicatransparente.domain.mapper.toEntity
import com.example.politicatransparente.domain.model.ResumoDeputado
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ResumoDeputadoRepository (
    private val api: ApiService,
    private val dao: ResumoDeputadoDao
) {

    fun getResumos(): Flow<List<ResumoDeputado>>{
        return dao.getAllDeputados().map { list ->
            list.map { it.toModel() }
        }
    }

    suspend fun refreshResumos(){
        val response = api.getDeputados()
        val entities = response.dados.map { it.toEntity() }
        dao.insertAll(entities)
    }

}