package com.example.projectakhir.service_api

import com.example.projectakhir.model.Acara

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
