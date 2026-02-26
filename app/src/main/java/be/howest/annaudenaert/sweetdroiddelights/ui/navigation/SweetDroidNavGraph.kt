package be.howest.annaudenaert.sweetdroiddelights.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.howest.annaudenaert.sweetdroiddelights.ui.desserts.DessertListScreen
import be.howest.annaudenaert.sweetdroiddelights.ui.desserts.DessertListViewModel
import be.howest.annaudenaert.sweetdroiddelights.ui.desserts.detail.DessertDetailScreen
import be.howest.annaudenaert.sweetdroiddelights.ui.desserts.detail.DessertDetailViewModel
import be.howest.annaudenaert.sweetdroiddelights.ui.home.HomeScreen
import be.howest.annaudenaert.sweetdroiddelights.ui.home.HomeViewModel

@Composable
fun SweetDroidNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel = viewModel(),
    dessertListViewModel : DessertListViewModel = viewModel(),
    dessertDetailViewModel : DessertDetailViewModel = viewModel()
) {
    val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val dessertListUiState by dessertListViewModel.uiState.collectAsStateWithLifecycle()
    val dessertDetailUiState by dessertDetailViewModel.uiState.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = "home", // TODO : Change this!
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(
                uiState = homeUiState,
                onEmailChanged = { homeViewModel.onEmailChanged(it) },
                onSubscribeClicked = homeViewModel::onSubscribeClicked,
                onOrderDessertClicked = { navController.navigate("desserts") }
            )
        }

        composable("desserts") {
            DessertListScreen(
                uiState = dessertListUiState,
                onDessertClicked = { dessertId -> navController.navigate("dessert/${dessertId}") }
            )
        }

        composable(Screen.DessertDetail.route) { backStackEntry ->
            val dessertId = backStackEntry.arguments?.getInt("dessertId")!!
            dessertDetailViewModel.loadDessert(dessertId)
            DessertDetailScreen(
                uiState = dessertDetailUiState
            )
        }

        //voeg hier routes toe naar andere schermen
    }
}