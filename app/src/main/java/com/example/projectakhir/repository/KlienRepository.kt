package com.example.projectakhir.repository

import com.example.projectakhir.model.Klien
import com.example.projectakhir.service_api.KlienService
import java.io.IOException

interface KlienRepository {
    suspend fun insertKlien(klien: Klien)
    suspend fun getAllKlien(): List<Klien>
    suspend fun updateKlien(id: Int, klien: Klien)
    suspend fun deleteKlien(id: Int)
    suspend fun getKlienById(id: Int): Klien
}
class NetworkKlienRepository(
    private val klienApiService: KlienService
) : KlienRepository {
    override suspend fun insertKlien(klien: Klien) {
        klienApiService.insertKlien(klien)
    }

    override suspend fun updateKlien(id: Int, klien: Klien) {
        klienApiService.updateKlien(id, klien)
    }

    override suspend fun deleteKlien(id: Int) {
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

    override suspend fun getAllKlien(): List<Klien> =
        klienApiService.getAllKlien()

    override suspend fun getKlienById(id: Int): Klien {
        return klienApiService.getKlienById(id)
    }
}