package com.example.politicatransparente.data.remote.dto

data class DeputadoResumoDto(
    val email: String,
    val id: Int,
    val idLegislatura: Int,
    val nome: String,
    val siglaPartido: String,
    val siglaUf: String,
    val uri: String,
    val uriPartido: String,
    val urlFoto: String
)
