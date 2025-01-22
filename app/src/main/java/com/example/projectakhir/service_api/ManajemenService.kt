package com.example.projectakhir.service_api

import com.example.projectakhir.model.Acara
import com.example.projectakhir.model.Klien
import com.example.projectakhir.model.Lokasi

interface AcaraService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("insertacara.php")
    suspend fun insertAcara(@Body acara: Acara)

    @GET("bacaacara.php")
    suspend fun getAllAcara(): List<Acara>

    @GET("baca1acara.php/{id}")
    suspend fun getAcaraById(@Path("id") id: Int): Acara

    @PUT("editacara.php/{id}")
    suspend fun updateAcara(@Path("id") id: Int, @Body acara: Acara)

    @DELETE("deleteacara.php/{id}")
    suspend fun deleteAcara(@Path("id") id: Int): Response<Void>
}
interface LokasiService {
    @POST("insertlokasi.php")
    suspend fun insertLokasi(@Body lokasi: Lokasi)

    @GET("bacalokasi.php")
    suspend fun getAllLokasi(): List<Lokasi>

    @GET("baca1lokasi.php/{id}")
    suspend fun getLokasiById(@Path("id") id: Int): Lokasi

    @PUT("editlokasi.php/{id}")
    suspend fun updateLokasi(@Path("id") id: Int, @Body lokasi: Lokasi)

    @DELETE("deletelokasi.php/{id}")
    suspend fun deleteLokasi(@Path("id") id: Int): Response<Void>
}

interface KlienService {
    @POST("insertklien.php")
    suspend fun insertKlien(@Body klien: Klien)

    @GET("bacaklien.php")
    suspend fun getAllKlien(): List<Klien>

    @GET("baca1klien.php/{id}")
    suspend fun getKlienById(@Path("id") id: Int): Klien

    @PUT("editklien.php/{id}")
    suspend fun updateKlien(@Path("id") id: Int, @Body klien: Klien)

    @DELETE("deleteklien.php/{id}")
    suspend fun deleteKlien(@Path("id") id: Int): Response<Void>
}