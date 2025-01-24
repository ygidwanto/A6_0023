package com.example.projectakhir.model



import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.InternalSerializationApi
@Serializable
data class VendorResponse(
    val status: Boolean,
    val message: String,
    val data: List<Vendor>
)
@kotlinx.serialization.InternalSerializationApi
@Serializable
data class DetailVendorResponse(
    val status: Boolean,
    val message: String,
    val data: Vendor
)
@kotlinx.serialization.InternalSerializationApi
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
