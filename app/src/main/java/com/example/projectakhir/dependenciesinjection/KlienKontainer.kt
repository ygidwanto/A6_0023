package com.example.projectakhir.dependenciesinjection

import com.example.projectakhir.repository.AcaraRepository
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.repository.NetworkAcaraRepository
import com.example.projectakhir.repository.NetworkKlienRepository
import com.example.projectakhir.service_api.AcaraService
import com.example.projectakhir.service_api.KlienService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainerKlien{
    val klienRepository: KlienRepository
}

class KlienKontainer : AppContainerKlien {

    private val baseUrl = "http://10.0.2.2:3000/api/acara"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val klienService: KlienService by lazy {
        retrofit.create(KlienService::class.java)
    }
    override val klienRepository: KlienRepository by lazy {
        NetworkKlienRepository(klienService)
    }
}