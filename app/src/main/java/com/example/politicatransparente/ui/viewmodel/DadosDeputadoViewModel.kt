package com.example.politicatransparente.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicatransparente.data.repository.DadosDeputadoRepository
import com.example.politicatransparente.domain.model.DadosDeputado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DadosDeputadoViewModel(
    private val repository: DadosDeputadoRepository) : ViewModel() {

    data class UiState(
        val isLoading: Boolean = false,
        val deputado: DadosDeputado? = null,
        val error: String? = null
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun carregarDeputado(id: Int) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }

                // Busca no banco/local
                repository.getDados(id).collect { deputado ->
                    if (deputado != null) {
                        _uiState.update { it.copy(deputado = deputado, isLoading = false) }
                    } else {
                        // Se não tiver, força refresh na API
                        repository.refreshDados(id)
                        val atualizado = repository.getDados(id).firstOrNull()
                        _uiState.update { it.copy(deputado = atualizado, isLoading = false) }
                    }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }

    fun refreshDeputado(id: Int) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, error = null) }
                repository.refreshDados(id)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }
}