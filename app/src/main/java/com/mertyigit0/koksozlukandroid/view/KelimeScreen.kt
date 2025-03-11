package com.mertyigit0.koksozlukandroid.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mertyigit0.koksozlukandroid.viewmodel.KelimeViewModel



@Composable
fun KelimeScreen(viewModel: KelimeViewModel) {
    // State'i gözlemleyelim
    val kelime = viewModel.kelime.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Başlık
        Text(text = "Kelime Göster", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Eğer kelime verisi varsa, göster
        kelime?.let {Column {
            Text(text = "Kelime: ${it.kelime}", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Anlam: ${it.anlam}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Örnek Cümle: ${it.ornek_cumle}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Alternatif Kelime: ${it.alternatif_kelime}", style = MaterialTheme.typography.bodyMedium)
        }

        }

        Spacer(modifier = Modifier.height(32.dp))

        // Yeni Kelime Butonu
        Button(
            onClick = { viewModel.fetchRandomKelime() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Yeni Kelime")
        }
    }
}
