package com.example.projectakhir.ui.viewmodel.klien

import android.R.id
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Klien
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.ui.view.klien.DetailKlienDestinasi

import kotlinx.coroutines.launch

@kotlinx.serialization.InternalSerializationApi
class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val klienRepository: KlienRepository
) : ViewModel() {
    private val klien: String = checkNotNull(savedStateHandle[DetailKlienDestinasi.titleRes])

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState())
        private set

    init {
        getKlienById()
    }

    private fun getKlienById() {
        viewModelScope.launch {
            detailUiState = DetailUiState(isLoading = true)
            try {
                val result = klienRepository.getKlienById(klien).data
                this@DetailViewModel.detailUiState = DetailUiState(
                    detailUiEvent = result.toDetailUiEvent(),
                    isLoading = false
                )
            } catch (e: Exception) {
                this@DetailViewModel.detailUiState = DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown"
                )
            }
        }
    }

    fun deleteKlien() {
        viewModelScope.launch {
            detailUiState = detailUiState.copy(isLoading = true)
            try {
                klienRepository.deleteKlien(klien)
                detailUiState = DetailUiState(
                    isLoading = false,
                    detailUiEvent = InsertUiEvent()
                ) // Kosongkan data setelah dihapus
            } catch (e: Exception) {
                detailUiState = detailUiState.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }


    data class DetailUiState(
        val detailUiEvent: InsertUiEvent = InsertUiEvent(),
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = ""
    ) {
        val isUiEventEmpty: Boolean
            get() = detailUiEvent == InsertUiEvent()

        val isUiEventNotEmpty: Boolean
            get() = detailUiEvent != InsertUiEvent()
    }

    @kotlinx.serialization.InternalSerializationApi

    fun Klien.toDetailUiEvent(): InsertUiEvent {
        return InsertUiEvent(
            id = id,
            namaKlien = namaKlien,
            kontakKlien = kontakKlien
        )
    }
}