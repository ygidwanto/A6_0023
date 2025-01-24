import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectakhir.ui.navigation.AddKlienDestinasi
import com.example.projectakhir.ui.navigation.KlienDestinasi
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
                    navController.navigate("${KlienDestinasi.route}/$id")
                },
                navigateToItemEntry = {navController.navigate(KlienDestinasi.route)},
            )
        }

        composable(
            route = AddKlienDestinasi.route
        ) {
            KlienInsertView(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
