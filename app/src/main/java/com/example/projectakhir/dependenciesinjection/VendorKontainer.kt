package com.example.projectakhir.dependenciesinjection

import com.example.projectakhir.repository.LokasiRepository
import com.example.projectakhir.repository.NetworkLokasiRepository
import com.example.projectakhir.repository.NetworkVendorRepository
import com.example.projectakhir.repository.VendorRepository
import com.example.projectakhir.service_api.LokasiService
import com.example.projectakhir.service_api.VendorService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainerVendor{
    val vendorRepository: VendorRepository
}

class VendorKontainer : AppContainerVendor {

    private val baseUrl = "http://10.0.2.2:3000/api/acara"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val vendorService: VendorService by lazy {
        retrofit.create(vendorService::class.java)
    }
    override val vendorRepository: VendorRepository by lazy {
        NetworkVendorRepository(vendorService)
    }
}