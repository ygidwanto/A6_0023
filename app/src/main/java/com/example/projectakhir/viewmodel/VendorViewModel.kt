package com.example.projectakhir.viewmodel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.model.Vendor
import com.example.projectakhir.repository.VendorRepository
import kotlinx.coroutines.launch

class VendorViewModel(
    private val vendorRepository: VendorRepository
) : ViewModel() {
    var vendorListUiState by mutableStateOf(VendorListUiState())
        private set

    init {
        loadVendorList()
    }

    private fun loadVendorList() {
        viewModelScope.launch {
            vendorListUiState = VendorListUiState(isLoading = true)
            try {
                val result = vendorRepository.getAllVendor()
                vendorListUiState = VendorListUiState(vendorList = result)
            } catch (e: Exception) {
                vendorListUiState = VendorListUiState(
                    isError = true,
                    errorMessage = e.message ?: "Unknown Error"
                )
            }
        }
    }

    fun deleteVendor(id: Int) {
        viewModelScope.launch {
            try {
                vendorRepository.deleteVendor(id)
                loadVendorList()
            } catch (e: Exception) {
                // Handle error if necessary
            }
        }
    }

    fun createVendor(vendor: Vendor) {
        viewModelScope.launch {
            try {
                vendorRepository.insertVendor(vendor)
                loadVendorList()
            } catch (e: Exception) {

            }
        }
    }

    fun updateVendor(id: Int, vendor: Vendor) {
        viewModelScope.launch {
            try {
                vendorRepository.updateVendor(id, vendor)
                loadVendorList()
            } catch (e: Exception) {

            }
        }
    }
}

data class VendorListUiState(
    val vendorList: List<Vendor> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
