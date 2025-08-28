package com.example.politicatransparente.domain.mapper

import com.example.politicatransparente.data.local.entities.DadosDeputadoEntity
import com.example.politicatransparente.data.local.entities.GabineteEntity
import com.example.politicatransparente.data.local.entities.UltimoStatusEntity
import com.example.politicatransparente.data.remote.dto.dadosdeputado.DadosDeputadoDto
import com.example.politicatransparente.data.remote.dto.dadosdeputado.GabineteDeputadoDto
import com.example.politicatransparente.data.remote.dto.dadosdeputado.UltimoStatusDeputadoDto
import com.example.politicatransparente.domain.model.DadosDeputado


fun DadosDeputadoDto.toEntity() = DadosDeputadoEntity(
    id = id,
    cpf = cpf,
    dataFalecimento = dataFalecimento,
    dataNascimento = dataNascimento,
    escolaridade = escolaridade,
    municipioNascimento = municipioNascimento,
    nomeCivil = nomeCivil,
    redeSocial = redeSocial,
    sexo = sexo,
    ufNascimento = ufNascimento,
    urlWebsite = urlWebsite,
    ultimoStatus = ultimoStatus.toEntity()
)

fun UltimoStatusDeputadoDto.toEntity() = UltimoStatusEntity(
    condicaoEleitoral = condicaoEleitoral,
    data = data,
    descricaoStatus = descricaoStatus,
    email = email,
    nomeEleitoral = nomeEleitoral,
    situacao = situacao,
    gabinete = gabinete.toEntity()
)

fun GabineteDeputadoDto.toEntity() = GabineteEntity(
    andar = andar,
    email = email,
    nome = nome,
    predio = predio,
    sala = sala,
    telefone = telefone
)

fun DadosDeputadoEntity.toModel() = DadosDeputado(
    id = id,
    cpf = cpf,
    dataNascimento = dataNascimento,
    dataFalecimento = dataFalecimento,
    escolaridade = escolaridade,
    municipioNascimento = municipioNascimento,
    nomeCivil = nomeCivil,
    redeSocial = redeSocial,
    sexo = sexo,
    ufNascimento = ufNascimento,
    urlWebsite = urlWebsite,
    condicaoEleitoral = ultimoStatus.condicaoEleitoral,
    data = ultimoStatus.data,
    descricaoStatus = ultimoStatus.descricaoStatus,
    nomeEleitoral = ultimoStatus.nomeEleitoral,
    statusEmail = ultimoStatus.email,
    situacao = ultimoStatus.situacao,
    andar = ultimoStatus.gabinete.andar,
    gabineteEmail = ultimoStatus.gabinete.email,
    nomeGabinete = ultimoStatus.gabinete.nome,
    predio = ultimoStatus.gabinete.predio,
    sala = ultimoStatus.gabinete.sala,
    telefone = ultimoStatus.gabinete.telefone
)


