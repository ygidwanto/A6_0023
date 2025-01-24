package com.example.projectakhir.repository

import com.example.projectakhir.model.Acara

import java.io.IOException

@kotlinx.serialization.InternalSerializationApi
interface AcaraRepository {
    suspend fun insertAcara(acara: Acara)
    suspend fun getAllAcara(): List<Acara>
    suspend fun updateAcara(id: Int, acara: Acara)
    suspend fun deleteAcara(id: Int)
    suspend fun getAcaraById(id: Int): Acara
}

@kotlinx.serialization.InternalSerializationApi
class NetworkAcaraRepository(
    private val acaraApiService: AcaraService
) : AcaraRepository {
    override suspend fun insertAcara(acara: Acara) {
        acaraApiService.insertAcara(acara)
    }

    override suspend fun updateAcara(id: Int, acara: Acara) {
        acaraApiService.updateAcara(id, acara)
    }

    override suspend fun deleteAcara(id: Int) {
        try {
            val response = acaraApiService.deleteAcara(id)
            if (!response.isSuccessful) {
                throw IOException("Gagal menghapus Acara. HTTP Status code: ${response.code()}")
            } else {
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }
    @kotlinx.serialization.InternalSerializationApi
    override suspend fun getAllAcara(): List<Acara> =
        acaraApiService.getAllAcara()

    override suspend fun getAcaraById(id: Int): Acara {
        return acaraApiService.getAcaraById(id)
    }
}