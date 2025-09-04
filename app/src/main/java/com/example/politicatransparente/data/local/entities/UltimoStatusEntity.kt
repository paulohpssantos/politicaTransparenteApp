package com.example.politicatransparente.data.local.entities

import androidx.room.Embedded

data class UltimoStatusEntity(
    val condicaoEleitoral: String?,
    val data: String?,
    val descricaoStatus: String?,
    val nomeEleitoral: String?,
    val email: String?,
    val situacao: String?,
    @Embedded(prefix = "gabinete_")
    val gabinete: GabineteEntity
)
