package com.example.politicatransparente.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politicatransparente.R
import com.example.politicatransparente.ui.adapter.DeputadoResumoAdapter
import com.example.politicatransparente.ui.viewmodel.DeputadoResumoViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ResumoDeputadosFragment : Fragment(R.layout.fragment_resumo_deputados) {

    private val viewModel: DeputadoResumoViewModel by viewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewError: TextView
    private lateinit var adapter: DeputadoResumoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewUsers)
        progressBar = view.findViewById(R.id.progressBar)
        textViewError = view.findViewById(R.id.textViewError)

        adapter = DeputadoResumoAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Observa o StateFlow da ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest { state ->
                    progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
                    textViewError.visibility = if (state.error != null) View.VISIBLE else View.GONE
                    recyclerView.visibility = if (state.resumos.isNotEmpty()) View.VISIBLE else View.GONE

                    textViewError.text = state.error ?: ""
                    adapter.updateData(state.resumos)
                }
            }
        }

        // Botão ou swipe para atualizar
        // ex: binding.swipeRefresh.setOnRefreshListener { viewModel.refreshUsers() }
    }
}