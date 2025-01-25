import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projectakhir.ui.navigation.AddKlienDestinasi
import com.example.projectakhir.ui.navigation.DestinasiUpdate
import com.example.projectakhir.ui.navigation.DetailKlienDestinasi
import com.example.projectakhir.ui.navigation.KlienDestinasi
import com.example.projectakhir.ui.view.klien.DetailView
import com.example.projectakhir.ui.view.klien.HomeScreen
import com.example.projectakhir.ui.view.klien.KlienInsertView

@kotlinx.serialization.InternalSerializationApi
@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = KlienDestinasi.route, modifier = modifier
    ) {
        composable(
            route = KlienDestinasi.route
        ) {
            HomeScreen(
                onDetailClick = { id->
                    navController.navigate("${DetailKlienDestinasi.route}/$id")
                },
                navigateToItemEntry = {navController.navigate(AddKlienDestinasi.route)},
            )
        }

        composable(
            route = AddKlienDestinasi.route
        ) {
            KlienInsertView(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            DetailKlienDestinasi.routeWithArgs,
            arguments = listOf(
                navArgument(DetailKlienDestinasi.IDClien){
                    type = NavType.StringType
                }
            )
        ) {
            val idHewan = it.arguments?.getString(DetailKlienDestinasi.IDClien)
            idHewan?.let {
                DetailView(
                    NavigateBack = {
                        navController.navigate(KlienDestinasi.route) {
                            popUpTo(KlienDestinasi.route) {
                                inclusive = true
                            }
                        }
                    },
                    onEditClick =  {navController.navigate("${DestinasiUpdate.route}/$it")},
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
//        composable(
//            DestinasiUpdateHewan.routeWithArgs,
//            arguments = listOf(
//                navArgument(DestinasiUpdateHewan.IDHEWAN) {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            UpdateViewHewan(
//                NavigateBack = {
//                    navController.popBackStack()
//                },
//                onNavigate = {
//                    navController.popBackStack()
//                },
//            )
//        }
    }
}
