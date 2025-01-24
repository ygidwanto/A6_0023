//package com.example.projectakhir.repository
//
//import com.example.projectakhir.model.Vendor
//import com.example.projectakhir.service_api.VendorService
//import java.io.IOException
//
//interface VendorRepository {
//    suspend fun insertVendor(vendor: Vendor)
//    suspend fun getAllVendor(): List<Vendor>
//    suspend fun updateVendor(id: Int, vendor: Vendor)
//    suspend fun deleteVendor(id: Int)
//    suspend fun getVendorById(id: Int): Vendor
//}
//class NetworkVendorRepository(
//    private val vendorApiService: VendorService
//) : VendorRepository {
//    override suspend fun insertVendor(vendor: Vendor) {
//        vendorApiService.insertVendor(vendor)
//    }
//
//    override suspend fun updateVendor(id: Int, vendor: Vendor) {
//        vendorApiService.updateVendor(id, vendor)
//    }
//
//    override suspend fun deleteVendor(id: Int) {
//        try {
//            val response = vendorApiService.deleteVendor(id)
//            if (!response.isSuccessful) {
//                throw IOException("Gagal menghapus Vendor. HTTP Status code: ${response.code()}")
//            } else {
//                println(response.message())
//            }
//        } catch (e: Exception) {
//            throw e
//        }
//    }
//
//    override suspend fun getAllVendor(): List<Vendor> =
//        vendorApiService.getAllVendor()
//
//    override suspend fun getVendorById(id: Int): Vendor {
//        return vendorApiService.getVendorById(id)
//    }
//}