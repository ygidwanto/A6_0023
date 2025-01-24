package com.example.projectakhir.ui.viewmodel.klien



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.projectakhir.model.Klien
import com.example.projectakhir.repository.KlienRepository
import kotlinx.coroutines.launch
import okio.IOException

@kotlinx.serialization.InternalSerializationApi
sealed class HomeUiState {
    data class Success(val klien: List<Klien>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

@kotlinx.serialization.InternalSerializationApi
class KlienHomeViewModel (private val klien: KlienRepository): ViewModel() {
    var klienUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getKlien()
    }

    @kotlinx.serialization.InternalSerializationApi
    fun getKlien() {
        viewModelScope.launch {
            klienUiState = HomeUiState.Loading
            klienUiState = try {
                HomeUiState.Success(klien.getAllKlien().data)
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}