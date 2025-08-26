package com.example.politicatransparente.domain.model

data class DeputadoResumo(

    val id: Int,
    val email: String,
    val idLegislatura: Int,
    val nome: String,
    val siglaPartido: String,
    val siglaUf: String,
    val uri: String,
    val uriPartido: String,
    val urlFoto: String
)
