package com.example.projectakhir

import android.app.Application
import com.example.projectakhir.dependenciesinjection.AppContainerKlien
import com.example.projectakhir.dependenciesinjection.KlienKontainer

@kotlinx.serialization.InternalSerializationApi
class ManajemenAcaraApplications: Application() {
    lateinit var KlienKontainer: AppContainerKlien
    override fun onCreate() {
        super.onCreate()
        KlienKontainer= KlienKontainer()
    }
}