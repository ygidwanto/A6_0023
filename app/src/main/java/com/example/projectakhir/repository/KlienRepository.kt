package com.example.projectakhir.repository

import com.example.projectakhir.model.DetailKlienResponse
import com.example.projectakhir.model.Klien
import com.example.projectakhir.model.KlienResponse
import com.example.projectakhir.service_api.KlienService

import java.io.IOException
@kotlinx.serialization.InternalSerializationApi
interface KlienRepository {
    suspend fun insertKlien(klien: Klien)

    suspend fun getAllKlien(): KlienResponse

    suspend fun updateKlien(id: String, klien: Klien)

    suspend fun deleteKlien(id: String)

    suspend fun getKlienById(id: String): DetailKlienResponse
}

@kotlinx.serialization.InternalSerializationApi
class NetworkKlienRepository(
    private val klienApiService: KlienService
) : KlienRepository {
    override suspend fun insertKlien(klien: Klien) {
        klienApiService.insertKlien(klien)
    }

    override suspend fun updateKlien(id: String, klien: Klien) {
        klienApiService.updateKlien(id, klien)
    }

    override suspend fun deleteKlien(id: String) {
        try {
            val response = klienApiService.deleteKlien(id)
            if (!response.isSuccessful) {
                throw IOException("Gagal menghapus Klien. HTTP Status code: ${response.code()}")
            } else {
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getAllKlien(): KlienResponse =
        klienApiService.getAllKlien()

    override suspend fun getKlienById(id: String): DetailKlienResponse {
        return klienApiService.getKlienById(id)
    }
}