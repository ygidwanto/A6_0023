package com.example.projectakhir.viewmodel



import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Acara
import com.example.projectakhir.repository.AcaraRepository
import kotlinx.coroutines.launch

class AcaraViewModel(
    private val acaraRepository: AcaraRepository
) : ViewModel() {
    var acaraListUiState by mutableStateOf(AcaraListUiState())
        private set

    init {
        loadAcaraList()
    }

    private fun loadAcaraList() {
        viewModelScope.launch {
            acaraListUiState = AcaraListUiState(isLoading = true)
            try {
                val result = acaraRepository.getAllAcara()
                acaraListUiState = AcaraListUiState(acaraList = result)
            } catch (e: Exception) {
                acaraListUiState = AcaraListUiState(
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }

    fun deleteAcara(id: Int) {
        viewModelScope.launch {
            try {
                acaraRepository.deleteAcara(id)
                loadAcaraList()
            } catch (e: Exception) {

            }
        }
    }

    fun createAcara(acara: Acara) {
        viewModelScope.launch {
            try {
                acaraRepository.insertAcara(acara)
                loadAcaraList() //
            } catch (e: Exception) {
            }
        }
    }

    fun updateAcara(id: Int, acara: Acara) {
        viewModelScope.launch {
            try {
                acaraRepository.updateAcara(id, acara)
                loadAcaraList()
            } catch (e: Exception) {
                // Handle error if necessary
            }
        }
    }
}

data class AcaraListUiState(
    val acaraList: List<Acara> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
