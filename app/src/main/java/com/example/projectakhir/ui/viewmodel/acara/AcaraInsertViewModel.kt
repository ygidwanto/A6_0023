//package com.example.projectakhir.ui.viewmodel.acara
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.projectakhir.model.Acara
//import com.example.projectakhir.model.Klien
//import com.example.projectakhir.repository.AcaraRepository
//import com.example.projectakhir.repository.KlienRepository
//import kotlinx.coroutines.launch
//
//@kotlinx.serialization.InternalSerializationApi
//class InsertViewModel(private val klien: AcaraRepository): ViewModel() {
//    var uiState by mutableStateOf(InsertUiState())
//        private set
//
//    fun updateInsertAcaraState(insertUiEvent: InsertUiEvent) {
//        uiState = InsertUiState(insertUiEvent = insertUiEvent)
//    }
//
//    fun insertAcara() {
//        viewModelScope.launch {
//            try {
//                klien.insertAcara(uiState.insertUiEvent.toAcara())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
//
//data class InsertUiState(
//    val insertUiEvent: InsertUiEvent = InsertUiEvent()
//)
//
//data class InsertUiEvent(
//    val id: Int = 0,
//    val namaAcara: String = "",
//    val deskripsiAcara: String = "",
//    val tanggalMulai: String ="",
//    val tanggalBerakhir: String="",
//    val idLokasi: Int = 0,
//    val idKlien: Int = 0,
//    val statusAcara: String= ""
//)
//
//@kotlinx.serialization.InternalSerializationApi
//fun InsertUiEvent.toAcara(): Acara = Acara(
//    id = id,
//    namaAcara = namaAcara,
//    deskripsiAcara = deskripsiAcara,
//    tanggalMulai = tanggalMulai,
//    tanggalBerakhir = tanggalBerakhir,
//    idLokasi = idLokasi,
//    idKlien = idKlien,
//    statusAcara = statusAcara
//)
//
//@kotlinx.serialization.InternalSerializationApi
//fun Klien.toUiStateKlien(): InsertUiState = InsertUiState(
//    insertUiEvent = toInsertUiEvent()
//)
//
//@kotlinx.serialization.InternalSerializationApi
//fun Klien.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
//    id = id,
//    namaAcara = namaAcara,
//    deskripsiAcara = deskripsiAcara,
//    tanggalMulai = tanggalMulai,
//    tanggalBerakhir = tanggalBerakhir,
//    idLokasi = idLokasi,
//    idKlien = idKlien,
//    statusAcara = statusAcara
//)
