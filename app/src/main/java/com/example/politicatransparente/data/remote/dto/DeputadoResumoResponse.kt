package com.example.politicatransparente.data.remote.dto

data class DeputadoResumoResponse (
    val dados: List<DeputadoResumoDto>,
    val links: List<LinkDto>
)