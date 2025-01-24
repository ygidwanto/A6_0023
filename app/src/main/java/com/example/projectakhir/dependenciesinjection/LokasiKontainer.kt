package com.example.projectakhir.dependenciesinjection

import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.repository.LokasiRepository
import com.example.projectakhir.repository.NetworkKlienRepository
import com.example.projectakhir.repository.NetworkLokasiRepository
import com.example.projectakhir.service_api.KlienService
import com.example.projectakhir.service_api.LokasiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainerLokasi{
    val lokasiRepository: LokasiRepository
}

class LokasiKontainer : AppContainerLokasi {

    private val baseUrl = "http://10.0.2.2:3000/api/acara"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val lokasiService: LokasiService by lazy {
        retrofit.create(LokasiService::class.java)
    }
    override val lokasiRepository: LokasiRepository by lazy {
        NetworkLokasiRepository(lokasiService)
    }
}