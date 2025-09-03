package com.example.politicatransparente.ui.view.dadosDeputado

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.politicatransparente.domain.model.ResumoDeputado
import com.example.politicatransparente.ui.viewmodel.DadosDeputadoViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun DadosGeraisTab(
    resumo: ResumoDeputado,
    viewModel: DadosDeputadoViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    // Carrega os dados do deputado ao abrir a tela
    LaunchedEffect(resumo.id) {
        println("Chamando carregarDeputado para id: ${resumo.id}")
        viewModel.carregarDeputado(resumo.id)
    }

    if (state.isLoading) {
        CircularProgressIndicator()
    } else {

        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = resumo.urlFoto,
                contentDescription = "Foto do Deputado",
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp)
            )

            state.deputado.let {

                Text(
                    text = "Dados Pessoais",
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

                Text("Nome Cívil: ${state.deputado?.nomeCivil}")
                Text("CPF: ${state.deputado?.cpf}")
                Text("Nascimento: ${state.deputado?.dataNascimento}")
                Text("Cidade: ${state.deputado?.municipioNascimento} - ${state.deputado?.ufNascimento}")
                Text(
                    "Sexo: " + when (state.deputado?.sexo) {
                        "F" -> "Feminino"
                        "M" -> "Masculino"
                        else -> "Não informado"
                    }
                )
                Text("Escolaridade: ${state.deputado?.escolaridade}")
                Text("Website: ${state.deputado?.urlWebsite}")


            }
        }

    }

}
