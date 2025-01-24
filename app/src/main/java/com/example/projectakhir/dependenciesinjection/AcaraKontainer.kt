package com.example.projectakhir.dependenciesinjection

import com.example.projectakhir.repository.AcaraRepository
import com.example.projectakhir.repository.NetworkAcaraRepository
import com.example.projectakhir.service_api.AcaraService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainerAcara {
    val acaraRepository: AcaraRepository
}

class AcaraKontainer : AppContainerAcara {

    private val baseUrl = "http://10.0.2.2:3000/api/acara"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val acaraService: AcaraService by lazy {
        retrofit.create(AcaraService::class.java)
    }
    override val acaraRepository: AcaraRepository by lazy {
        NetworkAcaraRepository(acaraService)
    }
}