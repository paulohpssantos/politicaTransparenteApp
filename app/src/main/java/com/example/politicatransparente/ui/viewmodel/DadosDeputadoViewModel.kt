package com.example.politicatransparente.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.politicatransparente.data.repository.DadosDeputadoRepository
import com.example.politicatransparente.domain.model.DadosDeputado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DadosDeputadoViewModel(
    private val repository: DadosDeputadoRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<DadosDeputado?>(null)
    val uiState: StateFlow<DadosDeputado?> = _uiState

    fun carregarDeputado(id: Int) {
        viewModelScope.launch {
            val entity = repository.getDados(id) // consulta Room/Remote
            entity?.let {
                _uiState.value = it.toModel // usa mapper
            }
        }
    }
}