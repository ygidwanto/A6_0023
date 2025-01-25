package com.example.projectakhir.service_api

import com.example.projectakhir.model.Acara
import com.example.projectakhir.model.DetailKlienResponse
import com.example.projectakhir.model.Klien
import com.example.projectakhir.model.KlienResponse
import com.example.projectakhir.model.Lokasi
import com.example.projectakhir.model.Vendor
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface KlienService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
    )
    @kotlinx.serialization.InternalSerializationApi
    @POST("store")
    suspend fun insertKlien(@Body klien: Klien)

    @kotlinx.serialization.InternalSerializationApi
    @GET(".")
    suspend fun getAllKlien(): KlienResponse

    @kotlinx.serialization.InternalSerializationApi
    @GET("{id_klien}")
    suspend fun getKlienById(@Path("id_klien") id: String): DetailKlienResponse

    @kotlinx.serialization.InternalSerializationApi
    @PUT("{id_klien}")
    suspend fun updateKlien(@Path("id_klien")id: String, @Body klien: Klien)

    @DELETE("{id_klien}")
    suspend fun deleteKlien(@Path("id_klien")id: String): Response<Void>
}
//interface LokasiService {
//    @POST("insertlokasi.php")
//    suspend fun insertLokasi(@Body lokasi: Lokasi)
//
//    @GET("bacalokasi.php")
//    suspend fun getAllLokasi(): List<Lokasi>
//
//    @GET("baca1lokasi.php/{id}")
//    suspend fun getLokasiById(@Path("id") id: Int): Lokasi
//
//    @PUT("editlokasi.php/{id}")
//    suspend fun updateLokasi(@Path("id") id: Int, @Body lokasi: Lokasi)
//
//    @DELETE("deletelokasi.php/{id}")
//    suspend fun deleteLokasi(@Path("id") id: Int): Response<Void>
//}
//
//interface KlienService {
//    @POST("insertklien.php")
//    suspend fun insertKlien(@Body klien: Klien)
//
//    @GET("bacaklien.php")
//    suspend fun getAllKlien(): List<Klien>
//
//    @GET("baca1klien.php/{id}")
//    suspend fun getKlienById(@Path("id") id: Int): Klien
//
//    @PUT("editklien.php/{id}")
//    suspend fun updateKlien(@Path("id") id: Int, @Body klien: Klien)
//
//    @DELETE("deleteklien.php/{id}")
//    suspend fun deleteKlien(@Path("id") id: Int): Response<Void>
//}
//interface VendorService {
//    @POST("insertvendor.php")
//    suspend fun insertVendor(@Body vendor: Vendor)
//
//    @GET("bacavendor.php")
//    suspend fun getAllVendor(): List<Vendor>
//
//    @GET("baca1vendor.php/{id}")
//    suspend fun getVendorById(@Path("id") id: Int): Vendor
//
//    @PUT("editvendor.php/{id}")
//    suspend fun updateVendor(@Path("id") id: Int, @Body vendor: Vendor)
//
//    @DELETE("deletevendor.php/{id}")
//    suspend fun deleteVendor(@Path("id") id: Int): Response<Void>
//}
