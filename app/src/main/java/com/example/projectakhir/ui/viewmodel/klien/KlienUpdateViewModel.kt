package com.example.projectakhir.ui.viewmodel.klien

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.ui.view.klien.DestinasiEntryKlien
import kotlinx.coroutines.launch

@kotlinx.serialization.InternalSerializationApi
class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val mahasiswaRepository: KlienRepository
) : ViewModel() {

    var updateUIState by mutableStateOf(InsertUiState())
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiEntryKlien.titleRes])

    init {
        viewModelScope.launch {
            updateUIState = KlienRepository.getKlienBy.Id(_id)
                .toUiStateKlien()
        }
    }

    fun updateInsertMhsState(insertUiEvent: InsertUiEvent){
        updateUIState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun updateData(){
        viewModelScope.launch {
            try {
                KlienRepository.updateKlien(_id, updateUIState.insertUiEvent.toKlien())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}