package com.example.politicatransparente.data.remote.dto.dadosdeputado

data class DadosDeputadoDto(
    val cpf: String,
    val dataFalecimento: String,
    val dataNascimento: String,
    val escolaridade: String,
    val id: Int,
    val municipioNascimento: String,
    val nomeCivil: String,
    val redeSocial: List<String>,
    val sexo: String,
    val ufNascimento: String,
    val ultimoStatus: UltimoStatusDeputadoDto,
    val uri: String,
    val urlWebsite: String
)
