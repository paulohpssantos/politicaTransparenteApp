package com.example.politicatransparente.ui.view.dadosDeputado

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.politicatransparente.R
import com.example.politicatransparente.domain.model.ResumoDeputado
import kotlinx.coroutines.launch

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun DadosDeputadoDrawerScreen(
    resumodeputado: ResumoDeputado

) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val urlLogoPartido = "https://raw.githubusercontent.com/paulohpssantos/appImages/main/logoPartidos/";

    val secoes = listOf(
        stringResource(id = R.string.pessoais), stringResource(id = R.string.despesas), stringResource(id = R.string.discursos), stringResource(id = R.string.eventos),
        stringResource(id = R.string.frentes),stringResource(id = R.string.historico),stringResource(id = R.string.mandatos_externos),
        stringResource(id = R.string.ocupacoes),stringResource(id = R.string.orgaos),stringResource(id = R.string.profissoes)
    )


    var secaoSelecionada by remember { mutableStateOf(0) }

    val context = LocalContext.current
    val ufImageName = resumodeputado.siglaUf.lowercase()
    val ufImageId = context.resources.getIdentifier(ufImageName, "drawable", context.packageName)

    ModalNavigationDrawer (
        drawerState = drawerState,
        drawerContent = {
            Column (modifier = Modifier
                .background(Color(0xFFEEEEEE))
                .padding(16.dp)
                .fillMaxHeight()
                .wrapContentWidth()) {
                Text(resumodeputado.nome, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                secoes.forEachIndexed { index, secao ->
                    Text(
                        text = secao,
                        modifier = Modifier
                            .clickable() {
                                secaoSelecionada = index
                                scope.launch { drawerState.close() }
                            }
                            .padding(vertical = 12.dp)
                    )
                }
                Image(
                    painter = painterResource(id = ufImageId),
                    contentDescription = resumodeputado.siglaUf,
                    modifier = Modifier
                        .size(100.dp)
                )

                //var url = PartidoImageUrls.urlPorSigla[resumodeputado.siglaPartido];
                //println("URL DO ICONE: ${url}")

                AsyncImage(
                    model = urlLogoPartido+resumodeputado.siglaPartido+".png",
                    contentDescription = "Logo do Partido",
                    modifier = Modifier
                        .size(100.dp)

                )
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
