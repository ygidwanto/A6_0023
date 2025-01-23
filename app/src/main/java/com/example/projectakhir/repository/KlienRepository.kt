package com.example.projectakhir.repository

import com.example.projectakhir.model.Klien

interface KlienRepository {
    suspend fun insertKlien(klien: Klien)
    suspend fun getAllKlien(): List<Klien>
    suspend fun updateKlien(id: Int, klien: Klien)
    suspend fun deleteKlien(id: Int)
    suspend fun getKlienById(id: Int): Klien
}