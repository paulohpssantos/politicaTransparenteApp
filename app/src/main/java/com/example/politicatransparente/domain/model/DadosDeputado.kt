package com.example.politicatransparente.domain.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.example.politicatransparente.data.local.entities.UltimoStatusEntity

data class DadosDeputado(
    val id: Int,
    val cpf: String,
    val dataFalecimento: String,
    val dataNascimento: String,
    val escolaridade: String,
    val municipioNascimento: String,
    val nomeCivil: String,
    val redeSocial: List<String>,
    val sexo: String,
    val ufNascimento: String,
    val urlWebsite: String,
    val condicaoEleitoral: String,
    val data: String,
    val descricaoStatus: String,
    val nomeEleitoral: String,
    val statusEmail: String,
    val situacao: String,
    val andar: String,
    val gabineteEmail: String,
    val nomeGabinete: String,
    val predio: String,
    val sala: String,
    val telefone: String
)
