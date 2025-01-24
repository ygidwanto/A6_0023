package com.example.projectakhir.ui.viewmodel.acara

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.projectakhir.repository.AcaraRepository
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.ui.viewmodel.klien.HomeUiState
import kotlinx.coroutines.launch
import okio.IOException

class KlienHomeViewModel (private val klien: AcaraRepository): ViewModel() {
    var klienUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getAcara()
    }

    @kotlinx.serialization.InternalSerializationApi
    fun getKlien() {
        viewModelScope.launch {
            klienUiState = HomeUiState.Loading
            klienUiState = try {
                HomeUiState.Success(klien.getAllAcara().data)
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}