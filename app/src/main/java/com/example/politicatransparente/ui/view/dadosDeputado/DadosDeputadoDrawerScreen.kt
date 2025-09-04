package com.example.politicatransparente.ui.view.dadosDeputado

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.politicatransparente.domain.model.ResumoDeputado
import com.example.politicatransparente.ui.viewmodel.DadosDeputadoViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun DadosDeputadoDrawerScreen(
    resumodeputado: ResumoDeputado

) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val secoes = listOf(
        "Pessoais", "Status", "Gabinete", "Redes",
        "Mandatos", "Comissões", "Projetos", "Discursos",
        "Agenda", "Contatos"
    )


    var secaoSelecionada by remember { mutableStateOf(0) }



    ModalNavigationDrawer (
        drawerState = drawerState,
        drawerContent = {
            Column (modifier = Modifier.padding(16.dp)) {
                Text("Seções", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                secoes.forEachIndexed { index, secao ->
                    Text(
                        text = secao,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable() {
                                secaoSelecionada = index
                                scope.launch { drawerState.close() }
                            }
                            .padding(vertical = 12.dp)
                    )
                }
            }
        }
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(resumodeputado.nome, fontSize = 25.sp) },

                    navigationIcon = {
                        IconButton (onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (secaoSelecionada) {
                    0 -> DadosGeraisTab(resumodeputado)
//                    1 -> StatusTab(deputadoId, viewModel)
//                    2 -> GabineteTab(deputadoId, viewModel)
//                    3 -> RedesTab(deputadoId, viewModel)
//                    4 -> ListaTab(deputadoId, "Mandatos", viewModel)
//                    5 -> ListaTab(deputadoId, "Comissões", viewModel)
//                    6 -> ListaTab(deputadoId, "Projetos", viewModel)
//                    7 -> ListaTab(deputadoId, "Discursos", viewModel)
//                    8 -> ListaTab(deputadoId, "Agenda", viewModel)
//                    9 -> ListaTab(deputadoId, "Contatos", viewModel)
                }
            }
        }
    }
}
