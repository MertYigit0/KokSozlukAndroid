package com.mertyigit0.koksozlukandroid.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mertyigit0.koksozlukandroid.data.model.KelimeDTO
import com.mertyigit0.koksozlukandroid.viewmodel.KelimeViewModel

@Composable
fun KelimeScreen(viewModel: KelimeViewModel) {
    val kelime = viewModel.kelime.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Dikey olarak ortalama
    ) {
        Text(
            text = "Kök Sözlük",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = Color(0xFF00BFFF) // Turkuaz rengi
        )

        Spacer(modifier = Modifier.height(16.dp))

        kelime?.let {
            // Kelime Kartı
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB2EBF2)) // Açık turkuaz
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Kelime: ${it.kelime}",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Anlam Kartı
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB2EBF2)) // Açık turkuaz
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Anlam: ${it.anlam}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Örnek Cümle Kartı
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB2EBF2)) // Açık turkuaz
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Örnek Cümle: ${it.ornek_cumle}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Alternatif Kelime Kartı
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB2EBF2)) // Açık turkuaz
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Alternatif Kelime: ${it.alternatif_kelime}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { viewModel.fetchRandomKelime() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00BFFF)) // Turkuaz rengi
        ) {
            Text("Yeni Kelime", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KelimeScreenPreview() {
    val fakeViewModel = viewModel<KelimeViewModel>().apply {
        kelime.value = KelimeDTO(
            kelime = "Uzam",
            anlam = "Bir şeyin kapladığı alan",
            ornek_cumle = "Bu yapının uzamı oldukça geniş.",
            alternatif_kelime = "Mekan"
        )
    }
    KelimeScreen(viewModel = fakeViewModel)
}