package com.example.politicatransparente.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.politicatransparente.R
import com.example.politicatransparente.domain.model.ResumoDeputado

class ResumoDeputadoAdapter(private var resumos: List<ResumoDeputado>): RecyclerView.Adapter<ResumoDeputadoAdapter.DeputadoResumoViewHolder>() {


    class DeputadoResumoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNome: TextView = itemView.findViewById(R.id.tvNomeDeputado)
        val textPartidoUF: TextView = itemView.findViewById(R.id.tvPartidoUF)
        val textEmail: TextView = itemView.findViewById(R.id.tvEmailDeputado)
        val imageViewFoto: ImageView = itemView.findViewById(R.id.ivFotoDeputado)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeputadoResumoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.resumo_deputado_item_list , parent, false)
        return DeputadoResumoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DeputadoResumoViewHolder,
        position: Int
    ) {
        val siglaPartido: String
        val dep = resumos[position]
        siglaPartido = dep.siglaPartido+" - "+dep.siglaUf
        holder.textNome.text = dep.nome
        holder.textPartidoUF.text = siglaPartido
        holder.textEmail.text = dep.email

        Glide.with(holder.itemView.context)
            .load(dep.urlFoto)
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_placeholder)
            .into(holder.imageViewFoto)
    }

    override fun getItemCount(): Int = resumos.size

    fun updateData(newResumos: List<ResumoDeputado>) {
        resumos = newResumos
        notifyDataSetChanged()
    }
}