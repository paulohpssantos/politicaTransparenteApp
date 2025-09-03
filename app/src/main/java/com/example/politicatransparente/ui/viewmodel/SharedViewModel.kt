package com.example.politicatransparente.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.politicatransparente.domain.model.ResumoDeputado

class SharedViewModel : ViewModel() {
    var resumoSelecionado: ResumoDeputado? = null
}