package com.example.projectakhir.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class AllAcaraResponse(
    val status: Boolean,
    val message: String,
    val data: List<Acara>
)

@InternalSerializationApi
@Serializable
data class DetailAcaraResponse(
    val status: Boolean,
    val message: String,
    val data: Acara
)
@InternalSerializationApi
@Serializable
data class Acara(
    @SerialName("id_acara")
    val id: Int,
    val namaAcara: String,
    @SerialName("nama_acara")
    val deskripsiAcara: String,
    @SerialName("tanggal_mulai")
    val tanggalMulai: String,
    @SerialName("tanggal_berakhir")
    val tanggalBerakhir: String,
    @SerialName("id_lokasi")
    val idLokasi: Int,
    @SerialName("id_klien")
    val idKlien: Int,
    @SerialName("status_acara")
    val statusAcara: String
)
