package com.mertyigit0.koksozlukandroid.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertyigit0.koksozlukandroid.data.api.RetrofitClient
import com.mertyigit0.koksozlukandroid.data.model.KelimeDTO
import kotlinx.coroutines.launch
import kotlin.random.Random

class KelimeViewModel : ViewModel() {

    // MutableState kullanımı
    val kelime = mutableStateOf<KelimeDTO?>(null)

    private val apiService = RetrofitClient.apiService

    // Rasgele kelimeyi almak için 0 ile 60 arasında rastgele bir ID üret
    fun fetchRandomKelime() {
        // Rastgele ID üret
        val randomId = Random.nextInt(0, 60)  // 0 ile 60 arasında rastgele bir id

        viewModelScope.launch {
            try {
                val response = apiService.getKelimeById(randomId.toLong())  // ID'yi API'ye gönder
                kelime.value = response  // State'e kelimeyi ekle
            } catch (e: Exception) {
                // Hata durumunu burada yakalayabilirsiniz.
                e.printStackTrace()
            }
        }
    }
}
