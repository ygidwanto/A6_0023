package com.example.projectakhir.ui.navigation



interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}


object VendorDestinasi : DestinasiNavigasi {
    override val route: String = "vendor_list"
    override val titleRes: String = "Daftar Vendor"
}

object AddVendorDestinasi : DestinasiNavigasi {
    override val route: String = "add_vendor"
    override val titleRes: String = "Tambah Vendor"
}

object LokasiDestinasi : DestinasiNavigasi {
    override val route: String = "lokasi_list"
    override val titleRes: String = "Daftar Lokasi"
}

object AddLokasiDestinasi : DestinasiNavigasi {
    override val route: String = "add_lokasi"
    override val titleRes: String = "Tambah Lokasi"
}

object AcaraDestinasi : DestinasiNavigasi {
    override val route: String = "acara_list"
    override val titleRes: String = "Daftar Acara"
}

object AddAcaraDestinasi : DestinasiNavigasi {
    override val route: String = "add_acara"
    override val titleRes: String = "Tambah Acara"
}

object KlienDestinasi : DestinasiNavigasi {
    override val route: String = "klien_list"
    override val titleRes: String = "Daftar Klien"
}

object AddKlienDestinasi : DestinasiNavigasi {
    override val route: String = "add_klien"
    override val titleRes: String = "Tambah Klien"
}

