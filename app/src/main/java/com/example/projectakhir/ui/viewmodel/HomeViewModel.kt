package com.example.projectakhir.ui.viewmodel



import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Acara
import com.example.projectakhir.model.Klien
import com.example.projectakhir.model.Lokasi
import com.example.projectakhir.model.Vendor
import com.example.projectakhir.repository.AcaraRepository
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.repository.LokasiRepository
import com.example.projectakhir.repository.VendorRepository
import kotlinx.coroutines.launch

import java.io.IOException

// Sealed class untuk merepresentasikan status UI Home
sealed class HomeUiState {
    data class Success(
        val vendors: List<Vendor>,
        val acara: List<Acara>,
        val lokasi: List<Lokasi>,
        val klien: List<Klien>
    ) : HomeUiState()

    object Error : HomeUiState()
    object Loading : HomeUiState()
}

// ViewModel untuk mengelola data di halaman utama aplikasi
class HomeViewModel(
    private val vendorRepository: VendorRepository,
    private val acaraRepository: AcaraRepository,
    private val lokasiRepository: LokasiRepository,
    private val klienRepository: KlienRepository
) : ViewModel() {
    var uiState by mutableStateOf<HomeUiState>(HomeUiState.Loading)
        private set

    // Inisialisasi ViewModel dan memuat data pada saat awal
    init {
        loadData()
    }

    // Memuat data dari semua repository
    private fun loadData() {
        viewModelScope.launch {
            uiState = HomeUiState.Loading
            try {
                // Mengambil data dari masing-masing repository
                val vendors = vendorRepository.getAllVendor()
                val acara = acaraRepository.getAllAcara()
                val lokasi = lokasiRepository.getAllLokasi()
                val klien = klienRepository.getAllKlien()

                // Mengupdate status UI dengan data yang berhasil dimuat
                uiState = HomeUiState.Success(vendors, acara, lokasi, klien)
            } catch (e: IOException) {
                uiState = HomeUiState.Error
            } catch (e: HttpException) {
                uiState = HomeUiState.Error
            }
        }
    }

    // Menghapus vendor berdasarkan ID dan memuat ulang data setelah penghapusan
    fun deleteVendor(id: Int) {
        viewModelScope.launch {
            try {
                vendorRepository.deleteVendor(id)
                loadData() // Refresh the list after deletion
            } catch (e: IOException) {
                uiState = HomeUiState.Error
            } catch (e: HttpException) {
                uiState = HomeUiState.Error
            }
        }
    }


    fun deleteAcara(id: Int) {
        viewModelScope.launch {
            try {
                acaraRepository.deleteAcara(id)
                loadData()
            } catch (e: IOException) {
                uiState = HomeUiState.Error
            } catch (e: HttpException) {
                uiState = HomeUiState.Error
            }
        }
    }

    fun deleteLokasi(id: Int) {
        viewModelScope.launch {
            try {
                lokasiRepository.deleteLokasi(id)
                loadData()
            } catch (e: IOException) {
                uiState = HomeUiState.Error
            } catch (e: HttpException) {
                uiState = HomeUiState.Error
            }
        }
    }

    fun deleteKlien(id: Int) {
        viewModelScope.launch {
            try {
                klienRepository.deleteKlien(id)
                loadData()
            } catch (e: IOException) {
                uiState = HomeUiState.Error
            } catch (e: HttpException) {
                uiState = HomeUiState.Error
            }
        }
    }
}
