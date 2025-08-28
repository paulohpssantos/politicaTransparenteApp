package com.example.politicatransparente.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.politicatransparente.data.remote.dto.dadosdeputado.UltimoStatusDeputadoDto

@Entity(tableName = "dados_deputado")
data class DadosDeputadoEntity(

    @PrimaryKey val id: Int,
    val cpf: String,
    val dataFalecimento: String,
    val dataNascimento: String,
    val escolaridade: String,
    val municipioNascimento: String,
    val nomeCivil: String,
    val redeSocial: List<String>,
    val sexo: String,
    val ufNascimento: String,
    @Embedded(prefix = "status_")
    val ultimoStatus: UltimoStatusEntity,
    val urlWebsite: String
)
