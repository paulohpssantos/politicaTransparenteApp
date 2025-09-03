package com.example.politicatransparente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.politicatransparente.ui.view.resumodeputado.ResumoDeputadosScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.politicatransparente.ui.view.dadosDeputado.DadosDeputadoDrawerScreen
import com.example.politicatransparente.ui.view.resumodeputado.ResumoDeputadosScreen
import com.example.politicatransparente.ui.viewmodel.SharedViewModel
import kotlin.getValue


class MainActivity : ComponentActivity() {
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                NavHost(navController, startDestination = "resumos") {
                    composable("resumos") {
                        ResumoDeputadosScreen { resumo ->
                            sharedViewModel.resumoSelecionado = resumo
                            navController.navigate("dadosDeputado")
                        }
                    }
                    composable("dadosDeputado") {
                        sharedViewModel.resumoSelecionado?.let { resumo ->
                            DadosDeputadoDrawerScreen(resumodeputado = resumo)
                        }
                    }
                }
            }
        }
    }
}
