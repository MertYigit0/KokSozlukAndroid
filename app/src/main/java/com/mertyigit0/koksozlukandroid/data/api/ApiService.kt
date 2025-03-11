package com.mertyigit0.koksozlukandroid.data.api

import com.mertyigit0.koksozlukandroid.data.model.KelimeDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // Belirli bir kelimeyi ID ile getirme
    @GET("api/kelime/{id}")
    suspend fun getKelimeById(@Path("id") id: Long): KelimeDTO
}