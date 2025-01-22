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

@Serializable
data class Lokasi(
    val id: Int,  // Primary Key
    val namaLokasi: String,
    val alamatLokasi: String,
    val kapasitas: Int
)

@Serializable
data class Klien(
    val id: Int,
    val namaKlien: String,
    val kontakKlien: String
)

@Serializable
data class Vendor(
    val id: Int,
    val namaVendor: String,

    @SerialName("jenis_vendor")
    val jenisVendor: String,

    val kontakVendor: String
)

