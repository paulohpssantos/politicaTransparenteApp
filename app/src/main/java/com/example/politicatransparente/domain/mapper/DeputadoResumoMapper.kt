package com.example.politicatransparente.domain.mapper

import com.example.politicatransparente.data.local.entities.DeputadoResumoEntity
import com.example.politicatransparente.data.remote.dto.DeputadoResumoDto
import com.example.politicatransparente.domain.model.DeputadoResumo


fun DeputadoResumoDto.toEntity() = DeputadoResumoEntity (
    id = this.id,
    email = this.email,
    idLegislatura = this.idLegislatura,
    nome = this.nome,
    siglaPartido = this.siglaPartido,
    siglaUf = this.siglaUf,
    uri = this.uri,
    uriPartido = this.uriPartido,
    urlFoto = this.urlFoto
)

fun DeputadoResumoEntity.toDomain() = DeputadoResumo (
    id = this.id,
    email = this.email,
    idLegislatura = this.idLegislatura,
    nome = this.nome,
    siglaPartido = this.siglaPartido,
    siglaUf = this.siglaUf,
    uri = this.uri,
    uriPartido = this.uriPartido,
    urlFoto = this.urlFoto
)
