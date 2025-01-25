package com.example.projectakhir.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@InternalSerializationApi
@Serializable
data class VendorResponse(
    val status: Boolean,
    val message: String,
    val data: List<Vendor>
)
@InternalSerializationApi
@Serializable
data class DetailVendorResponse(
    val status: Boolean,
    val message: String,
    val data: Vendor
)
@InternalSerializationApi
@Serializable
data class Vendor(
    @SerialName("id_vendor")
    val id: Int,
    @SerialName("nama_vendor")
    val namaVendor: String,

    @SerialName("jenis_vendor")
    val jenisVendor: String,
    @SerialName("kontak_vendor")
    val kontakVendor: String
)
