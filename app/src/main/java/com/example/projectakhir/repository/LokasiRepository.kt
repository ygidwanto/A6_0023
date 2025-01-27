package com.example.projectakhir.repository

import com.example.projectakhir.model.Lokasi
import com.example.projectakhir.service_api.LokasiService
import java.io.IOException

@kotlinx.serialization.InternalSerializationApi
interface LokasiRepository {
    suspend fun insertLokasi(lokasi: Lokasi)
    suspend fun getAllLokasi(): List<Lokasi>
    suspend fun updateLokasi(id: Int, lokasi: Lokasi)
    suspend fun deleteLokasi(id: Int)
    suspend fun getLokasiById(id: Int): Lokasi
}
@kotlinx.serialization.InternalSerializationApi

class NetworkLokasiRepository(
    private val lokasiApiService: LokasiService
) : LokasiRepository {
    override suspend fun insertLokasi(lokasi: Lokasi) {
        lokasiApiService.insertLokasi(lokasi)
    }

    override suspend fun updateLokasi(id: Int, lokasi: Lokasi) {
        lokasiApiService.updateLokasi(id, lokasi)
    }

    override suspend fun deleteLokasi(id: Int) {
        try {
            val response = lokasiApiService.deleteLokasi(id)
            if (!response.isSuccessful) {
                throw IOException("Gagal menghapus Lokasi. HTTP Status code: ${response.code()}")
            } else {
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getAllLokasi(): List<Lokasi> =
        lokasiApiService.getAllLokasi()

    override suspend fun getLokasiById(id: Int): Lokasi {
        return lokasiApiService.getLokasiById(id)
    }
}