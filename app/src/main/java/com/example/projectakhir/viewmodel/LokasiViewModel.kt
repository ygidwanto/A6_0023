package com.example.projectakhir.viewmodel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Lokasi
import com.example.projectakhir.repository.LokasiRepository
import kotlinx.coroutines.launch

class LokasiViewModel(
    private val lokasiRepository: LokasiRepository
) : ViewModel() {
    var lokasiListUiState by mutableStateOf(LokasiListUiState())
        private set

    init {
        loadLokasiList()
    }

    private fun loadLokasiList() {
        viewModelScope.launch {
            lokasiListUiState = LokasiListUiState(isLoading = true)
            try {
                val result = lokasiRepository.getAllLokasi()
                lokasiListUiState = LokasiListUiState(lokasiList = result)
            } catch (e: Exception) {
                lokasiListUiState = LokasiListUiState(
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }

    fun deleteLokasi(id: Int) {
        viewModelScope.launch {
            try {
                lokasiRepository.deleteLokasi(id)
                loadLokasiList()
            } catch (e: Exception) {

            }
        }
    }

    fun createLokasi(lokasi: Lokasi) {
        viewModelScope.launch {
            try {
                lokasiRepository.insertLokasi(lokasi)
                loadLokasiList()
            } catch (e: Exception) {

            }
        }
    }

    fun updateLokasi(id: Int, lokasi: Lokasi) {
        viewModelScope.launch {
            try {
                lokasiRepository.updateLokasi(id, lokasi)
                loadLokasiList()
            } catch (e: Exception) {

            }
        }
    }
}

data class LokasiListUiState(
    val lokasiList: List<Lokasi> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
