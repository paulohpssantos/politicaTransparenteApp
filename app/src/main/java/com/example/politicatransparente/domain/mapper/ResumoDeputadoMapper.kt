package com.example.politicatransparente.domain.mapper

import com.example.politicatransparente.data.local.entities.ResumoDeputadoEntity
import com.example.politicatransparente.data.remote.dto.resumodeputado.ResumoDeputadoDto
import com.example.politicatransparente.domain.model.ResumoDeputado


fun ResumoDeputadoDto.toEntity() = ResumoDeputadoEntity (
    id = this.id,
    email = this.email,
    idLegislatura = this.idLegislatura,
    nome = this.nome,
    siglaPartido = this.siglaPartido,
    siglaUf = this.siglaUf,
    urlFoto = this.urlFoto
)

fun ResumoDeputadoEntity.toModel() = ResumoDeputado (
    id = this.id,
    email = this.email,
    idLegislatura = this.idLegislatura,
    nome = this.nome,
    siglaPartido = this.siglaPartido,
    siglaUf = this.siglaUf,
    urlFoto = this.urlFoto
)
