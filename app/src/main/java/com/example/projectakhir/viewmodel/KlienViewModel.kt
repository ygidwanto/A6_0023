package com.example.projectakhir.viewmodel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Klien
import com.example.projectakhir.repository.KlienRepository
import kotlinx.coroutines.launch

class KlienViewModel(
    private val klienRepository: KlienRepository
) : ViewModel() {
    var klienListUiState by mutableStateOf(KlienListUiState())
        private set

    init {
        loadKlienList()
    }

    private fun loadKlienList() {
        viewModelScope.launch {
            klienListUiState = KlienListUiState(isLoading = true)
            try {
                val result = klienRepository.getAllKlien()
                klienListUiState = KlienListUiState(klienList = result)
            } catch (e: Exception) {
                klienListUiState = KlienListUiState(
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }

    fun deleteKlien(id: Int) {
        viewModelScope.launch {
            try {
                klienRepository.deleteKlien(id)
                loadKlienList()
            } catch (e: Exception) {

            }
        }
    }

    fun createKlien(klien: Klien) {
        viewModelScope.launch {
            try {
                klienRepository.insertKlien(klien)
                loadKlienList()
            } catch (e: Exception) {

            }
        }
    }

    fun updateKlien(id: Int, klien: Klien) {
        viewModelScope.launch {
            try {
                klienRepository.updateKlien(id, klien)
                loadKlienList() // Refresh the list after update
            } catch (e: Exception) {
                // Handle error if necessary
            }
        }
    }
}

data class KlienListUiState(
    val klienList: List<Klien> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)

