package com.example.projectakhir.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.InternalSerializationApi
@Serializable
data class KlienResponse(
    val status: Boolean,
    val message: String,
    val data: List<Klien>
)
@kotlinx.serialization.InternalSerializationApi
@Serializable
data class DetailKlienResponse(
    val status: Boolean,
    val message: String,
    val data: Klien
)
@kotlinx.serialization.InternalSerializationApi
@Serializable
data class Klien(
    @SerialName("id_klien")
    val id: Int,
    @SerialName("nama_klien")
    val namaKlien: String,
    @SerialName("kontak_klien")
    val kontakKlien: String
)
