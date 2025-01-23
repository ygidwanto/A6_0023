package com.example.projectakhir.repository

import com.example.projectakhir.model.Lokasi

interface LokasiRepository {
    suspend fun insertLokasi(lokasi: Lokasi)
    suspend fun getAllLokasi(): List<Lokasi>
    suspend fun updateLokasi(id: Int, lokasi: Lokasi)
    suspend fun deleteLokasi(id: Int)
    suspend fun getLokasiById(id: Int): Lokasi
}