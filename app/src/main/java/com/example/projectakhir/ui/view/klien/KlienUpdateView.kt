//package com.example.projectakhir.ui.view.klien
//
//import android.R.attr.id
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.projectakhir.ui.customwidget.CustomeTopAppBar
//import com.example.projectakhir.ui.navigation.DestinasiNavigasi
//import com.example.projectakhir.ui.viewmodel.PenyediaViewModel
//import com.example.projectakhir.ui.viewmodel.klien.UpdateViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import java.lang.reflect.Modifier
//
//
//object DestinasiUpdate : DestinasiNavigasi {
//    override val route = "update"
//    override val titleRes = "Edit Klien"
//    const val NIM = "id"
//    val routeWithArgs = "$route/{$id}"
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun UpdateView(
//    NavigateBack: () -> Unit,
//    onNavigate:()-> Unit,
//    modifier: Modifier = Modifier,
//    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
//){
//    val coroutineScope = rememberCoroutineScope()
//
//    Scaffold (
//        modifier = modifier,
//        topBar = {
//            CustomeTopAppBar(
//                title = DestinasiUpdate.titleRes,
//                canNavigateBack = true,
//                navigateUp = NavigateBack,
//            )
//        }
//    ){ padding ->
//        EntryBody(
//            modifier = Modifier.padding(padding),
//            onSiswaValueChange = viewModel::updateInsertMhsState,
//            insertUiState = viewModel.updateUIState,
//            onSaveClick = {
//                coroutineScope.launch {
//                    viewModel.updateData()
//                    delay(600)
//                    withContext(Dispatchers.Main){
//                        onNavigate()
//                    }
//                }
//            }
//        )
//    }
//}