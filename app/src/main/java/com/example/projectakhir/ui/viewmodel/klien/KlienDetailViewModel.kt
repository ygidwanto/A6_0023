package com.example.projectakhir.ui.viewmodel.klien

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Klien
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.ui.view.klien.DestinasiEntryKlien
import kotlinx.coroutines.launch

@kotlinx.serialization.InternalSerializationApi
class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val klienRepository: KlienRepository
) : ViewModel() {
    private val klien: String = checkNotNull(savedStateHandle[DestinasiEntryKlien.titleRes])

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState())
        private set

    init {
        getKlienById()
    }

    private fun getKlienById() {
        viewModelScope.launch {
            detailUiState = DetailUiState(isLoading = true)
            try {
                val result = KlienRepository.getKlienById(klienId)
                detailUiState = DetailUiState(
                    detailUiEvent = result.toDetailUiEvent(),
                    isLoading = false
                )
            } catch (e: Exception) {
                detailUiState = DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown"
                )
            }
        }
    }

    fun deleteKlien() {
        viewModelScope.launch {
            detailUiState = DetailUiState(isLoading = true)
            try {
                KlienRepository.deleteKlien(klienId)

                detailUiState = DetailUiState(isLoading = false)
            } catch (e: Exception) {
                detailUiState = DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }
}


data class DetailUiState(
    val detailUiEvent: InsertUiEvent = InsertUiEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == InsertUiEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != InsertUiEvent()
}

fun Klien.toDetailUiEvent(): InsertUiEvent{
    return InsertUiEvent(
        id = id,
        namaKlien = namaKlien,
        kontakKlien = kontakKlien
    )
}