package com.mertyigit0.koksozlukandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mertyigit0.koksozlukandroid.ui.theme.KokSozlukAndroidTheme
import com.mertyigit0.koksozlukandroid.view.KelimeScreen
import com.mertyigit0.koksozlukandroid.viewmodel.KelimeViewModel

class MainActivity : ComponentActivity() {
    private val kelimeViewModel: KelimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KelimeScreen(viewModel = kelimeViewModel)
        }

        // Ekran yüklendiğinde rastgele kelimeyi al
        kelimeViewModel.fetchRandomKelime()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KokSozlukAndroidTheme {
        Greeting("Android")
    }
}