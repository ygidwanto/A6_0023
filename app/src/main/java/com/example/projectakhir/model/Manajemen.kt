package com.example.projectakhir.model

@Serializable
data class Acara(
    val id: Int,  // Primary Key
    val namaAcara: String,
    val deskripsiAcara: String,
    val tanggalMulai: String,
    val tanggalBerakhir: String,
    val idLokasi: Int,  // Foreign Key ke tabel Lokasi
    val idKlien: Int,   // Foreign Key ke tabel Klien
    val statusAcara: String // (Direncanakan, Berlangsung, Selesai)
)


