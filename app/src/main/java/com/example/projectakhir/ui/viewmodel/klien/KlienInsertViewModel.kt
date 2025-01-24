package com.example.projectakhir.ui.viewmodel.klien

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.model.Klien
import kotlinx.coroutines.launch

@kotlinx.serialization.InternalSerializationApi
class InsertViewModel(private val klien: KlienRepository): ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertKlienState(insertUiEvent: InsertUiEvent) {
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertKlien() {
        viewModelScope.launch {
            try {
                klien.insertKlien(uiState.insertUiEvent.toKlien())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

data class InsertUiEvent(
    val id: Int = 0,
    val namaKlien: String = "",
    val kontakKlien: String = ""
)

@kotlinx.serialization.InternalSerializationApi
fun InsertUiEvent.toKlien(): Klien = Klien(
    id = id,
    namaKlien = namaKlien,
    kontakKlien = kontakKlien
)

@kotlinx.serialization.InternalSerializationApi
fun Klien.toUiStateKlien(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)

@kotlinx.serialization.InternalSerializationApi
fun Klien.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    namaKlien = namaKlien,
    kontakKlien = kontakKlien
)
