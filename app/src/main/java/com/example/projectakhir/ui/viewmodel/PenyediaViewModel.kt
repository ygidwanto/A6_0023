package com.example.projectakhir.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectakhir.ManajemenAcaraApplications
import com.example.projectakhir.repository.KlienRepository
import com.example.projectakhir.ui.viewmodel.klien.InsertViewModel
import com.example.projectakhir.ui.viewmodel.klien.KlienHomeViewModel

@kotlinx.serialization.InternalSerializationApi
object PenyediaViewModel {
    // Factory class to provide ViewModel instances
    val Factory= viewModelFactory {
        initializer { KlienHomeViewModel(aplikasiManajemen().KlienKontainer.klienRepository) }
        initializer { InsertViewModel (aplikasiManajemen().KlienKontainer.klienRepository)}
    }
}

@kotlinx.serialization.InternalSerializationApi
fun CreationExtras.aplikasiManajemen(): ManajemenAcaraApplications =
    ((this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as ManajemenAcaraApplications))