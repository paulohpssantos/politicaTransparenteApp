package com.example.politicatransparente.ui.view.resumodeputado

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.politicatransparente.domain.model.ResumoDeputado

@Composable
fun ResumoDeputadoItem(resumo: ResumoDeputado, onClick:() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = resumo.urlFoto,
                contentDescription = "Foto do Deputado",
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = resumo.nome, style = MaterialTheme.typography.titleMedium)
                Text(text = "${resumo.siglaPartido} - ${resumo.siglaUf}", style = MaterialTheme.typography.bodyMedium)
                Text(text = resumo.email, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}