package com.example.projectakhir.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class LokasiResponse(
    val status: Boolean,
    val message: String,
    val data: List<Lokasi>
)
@InternalSerializationApi
@Serializable
data class DetailLokasiResponse(
    val status: Boolean,
    val message: String,
    val data: Lokasi
)
@InternalSerializationApi
@Serializable
data class Lokasi(
    @SerialName("id_lokasi")
    val id: Int,
    @SerialName("nama_lokasi")
    val namaLokasi: String,
    @SerialName("alamat_lokasi")
    val alamatLokasi: String,
    val kapasitas: Int
)