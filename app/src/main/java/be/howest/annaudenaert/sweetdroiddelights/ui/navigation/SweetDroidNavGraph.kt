package be.howest.annaudenaert.sweetdroiddelights.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import be.howest.annaudenaert.sweetdroiddelights.ui.home.HomeScreen

@Composable
fun SweetDroidNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") {
            HomeScreen(
                onOrderDessertClick = { navController.navigate("desserts") },
                onSubscribeClick = {}
            )
        }

        composable("desserts") {
           // add your desserts screen here
        }

    }
}
