package com.example.politicatransparente.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resumo_deputado")
data class ResumoDeputadoEntity(

    @PrimaryKey val id: Int,
    val email: String,
    val idLegislatura: Int,
    val nome: String,
    val siglaPartido: String,
    val siglaUf: String,
    val urlFoto: String
)