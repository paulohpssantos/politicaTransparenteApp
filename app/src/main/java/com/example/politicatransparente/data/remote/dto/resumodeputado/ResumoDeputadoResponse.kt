package com.example.politicatransparente.data.remote.dto.resumodeputado

import com.example.politicatransparente.data.remote.dto.LinkDto

data class ResumoDeputadoResponse (
    val dados: List<ResumoDeputadoDto>,
    val links: List<LinkDto>
)