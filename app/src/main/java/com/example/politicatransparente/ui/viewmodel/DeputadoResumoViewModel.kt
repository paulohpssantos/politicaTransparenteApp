package com.example.politicatransparente.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicatransparente.data.repository.DeputadoResumoRepository
import com.example.politicatransparente.domain.model.DeputadoResumo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DeputadoResumoViewModel(
    private val repository: DeputadoResumoRepository
) : ViewModel(){

    //Estado da tela (carregando, sucesso, erro)
    data class UiState(
        val isLoading: Boolean = false,
        val resumos: List<DeputadoResumo> = emptyList(),
        val error: String? = null
    )

    private val _uiState = MutableStateFlow(UiState())
    private val uiState: StateFlow<UiState> = _uiState.asStateFlow();

    init {
        // Carrega os resumos dos deputados salvos localmente (Room → Flow)
        viewModelScope.launch{
            repository.getResumos().collect { resumos ->
                _uiState.update { it.copy(resumos = resumos)}
            }
        }
        // Atualiza dados logo no início
        refreshResumos()
    }

    fun refreshResumos() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }
                repository.refreshResumos()
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

}