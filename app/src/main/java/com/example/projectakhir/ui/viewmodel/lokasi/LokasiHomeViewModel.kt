package com.example.projectakhir.ui.viewmodel.lokasi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.projectakhir.model.Lokasi
import com.example.projectakhir.repository.LokasiRepository
import kotlinx.coroutines.launch
import okio.IOException

@kotlinx.serialization.InternalSerializationApi
sealed class HomeUiState {
    data class Success(val lokasi: List<Lokasi>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

@kotlinx.serialization.InternalSerializationApi
class LokasiHomeViewModel(private val lokasiRepository: LokasiRepository) : ViewModel() {
    var lokasiUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getLokasi()
    }

    @kotlinx.serialization.InternalSerializationApi
    fun getLokasi() {
        viewModelScope.launch {
            lokasiUiState = HomeUiState.Loading
            lokasiUiState = try {
                HomeUiState.Success(lokasiRepository.getAllLokasi())
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}
