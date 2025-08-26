package com.example.politicatransparente.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deputado_resumo")
data class DeputadoResumoEntity(

    @PrimaryKey val id: Int,
    val email: String,
    val idLegislatura: Int,
    val nome: String,
    val siglaPartido: String,
    val siglaUf: String,
    val uri: String,
    val uriPartido: String,
    val urlFoto: String
)