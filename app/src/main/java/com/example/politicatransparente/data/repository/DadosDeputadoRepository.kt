package com.example.politicatransparente.data.repository

import com.example.politicatransparente.data.local.dao.DadosDeputadoDao
import com.example.politicatransparente.data.remote.ApiService
import com.example.politicatransparente.domain.mapper.toEntity
import com.example.politicatransparente.domain.mapper.toModel
import com.example.politicatransparente.domain.model.DadosDeputado
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DadosDeputadoRepository(
    private val api: ApiService,
    private val dao: DadosDeputadoDao
) {
    fun getDados(id: Int): Flow<DadosDeputado?> {
        return dao.getDeputadoById(id).map { it?.toModel() }
    }

    suspend fun refreshDados(id: Int){
        val response = api.getDeputadoPorId(id)
        val entity = response.dados.toEntity()
        dao.insert(entity)
    }
}