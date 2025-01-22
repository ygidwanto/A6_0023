package com.example.projectakhir.model

@Serializable
data class Acara(
    val id: Int,
    val namaAcara: String,
    val deskripsiAcara: String,
    val tanggalMulai: String,
    val tanggalBerakhir: String,
    val idLokasi: Int,
    val idKlien: Int,
    val statusAcara: String
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

