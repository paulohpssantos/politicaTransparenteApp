package com.example.politicatransparente.ui.view.dadosDeputado

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.politicatransparente.R
import com.example.politicatransparente.domain.model.ResumoDeputado
import com.example.politicatransparente.ui.viewmodel.DadosDeputadoViewModel
import org.koin.androidx.compose.koinViewModel
import com.example.politicatransparente.ui.utils.RedesSociaisIcons


@Composable
fun DadosGeraisTab(
    resumo: ResumoDeputado,
    viewModel: DadosDeputadoViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    // Carrega os dados do deputado ao abrir a tela
    LaunchedEffect(resumo.id) {
        viewModel.carregarDeputado(resumo.id)
    }

    when {
        state.isLoading -> {
            CircularProgressIndicator()
        }
        state.deputado != null -> {
            val deputado = state.deputado!!
            Column(modifier = Modifier
                .padding(16.dp)) {

                Column (modifier = Modifier
                    .fillMaxWidth()){

                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.CenterHorizontally),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)

                    )
                    {
                        AsyncImage(
                            model = resumo.urlFoto,
                            contentDescription = "Foto do Deputado",
                            modifier = Modifier
                                .size(200.dp)
                                .padding(top = 15.dp, bottom = 15.dp)
                        )
                    }

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.partido)+": ")
                            }
                            append(resumo.siglaPartido+" - "+resumo.siglaUf)
                        },
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.condicao_eleitoral)+": ")
                            }
                            append(deputado.condicaoEleitoral)
                        },
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.situacao)+": ")
                            }
                            append(deputado.situacao)
                        },
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding( bottom = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                }

                Column(modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    ) {


                    /******************** Dados Pessoais *********************/
                    Text(
                        text = stringResource(id = R.string.dados_pessoais),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.nome_civil)+": ")
                            }
                            append(deputado.nomeCivil)
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.cpf)+": ")
                            }
                            append(deputado.cpf)
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.nascimento)+": ")
                            }
                            append(deputado.dataNascimento)
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.cidade)+": ")
                            }
                            append(deputado.municipioNascimento+" - "+deputado.ufNascimento)
                        }
                    )
                    if(deputado.dataFalecimento.isNotEmpty()){
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(stringResource(id = R.string.falecimento)+": ")
                                }
                                append(deputado.dataFalecimento)
                            }
                        )
                    }
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.sexo)+": ")
                            }
                            append( when (deputado.sexo) {
                                "F" -> stringResource(id = R.string.feminino)
                                "M" -> stringResource(id = R.string.masculino)
                                else -> stringResource(id = R.string.nao_informado)
                            })
                        }
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.escolaridade)+": ")
                            }
                            append(deputado.escolaridade)
                        }
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.website)+": ")
                            }
                            append(deputado.urlWebsite)
                        }
                    )

                    // Para cada url de rede social, cria um link clicável
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.redes_sociais)+": ")
                            }
                        }
                    )
                    RedesSociaisIcons(deputado.redeSocial)

                    /******************** Dados Pessoais *********************/

                    /******************** Gabinete *********************/
                    Text(
                        text = stringResource(id = R.string.gabinete),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Row {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(stringResource(id = R.string.nome) + ": ")
                                }
                                append(deputado.nomeGabinete)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(stringResource(id = R.string.predio) + ": ")
                                }
                                append(deputado.predio)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(stringResource(id = R.string.sala) + ": ")
                                }
                                append(deputado.sala)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(stringResource(id = R.string.andar) + ": ")
                                }
                                append(deputado.andar)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.telefone) + ": ")
                            }
                            append(deputado.telefone)
                        }
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(stringResource(id = R.string.email) + ": ")
                            }
                            append(deputado.gabineteEmail)
                        }
                    )

                }




            }
        }
        else -> {
            Text("Nenhum dado encontrado para o deputado.")
        }
    }
}


