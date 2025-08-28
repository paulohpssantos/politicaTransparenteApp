package com.example.politicatransparente.data.remote.dto.dadosdeputado

import com.example.politicatransparente.data.remote.dto.LinkDto

data class DadosDeputadoResponse(
    val dados: DadosDeputadoDto,
    val links: List<LinkDto>
)
