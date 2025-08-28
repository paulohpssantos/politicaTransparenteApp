package com.example.politicatransparente.domain.model

data class ResumoDeputado(

    val id: Int,
    val email: String,
    val idLegislatura: Int,
    val nome: String,
    val siglaPartido: String,
    val siglaUf: String,
    val urlFoto: String
)
