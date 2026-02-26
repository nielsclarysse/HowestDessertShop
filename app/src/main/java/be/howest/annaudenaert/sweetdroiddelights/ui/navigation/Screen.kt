package be.howest.annaudenaert.sweetdroiddelights.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import be.howest.annaudenaert.sweetdroiddelights.R

sealed class Screen(
    val route: String,
    @StringRes val labelResourceId: Int,
    val icon: ImageVector
) {
    data object Home: Screen("home", R.string.home_label, Icons.Filled.Home)
    data object Desserts: Screen("desserts", R.string.shop_label, Icons.Filled.Search)

    data object DessertDetail: Screen("dessert/{dessertId}", R.string.shop_label, Icons.Filled.Search)

    data object ShoppingCart: Screen("shopping_cart", R.string.shopping_cart_label, Icons.Filled.Search)


    //vul zelf aan met de andere schermen (vergeet hier niet om eerst de composables aan te maken)
}

val screens = listOf(
    Screen.Home,
    Screen.Desserts,
    Screen.ShoppingCart,
    /*Screen.PickupLocation,
    Screen.Profile*/
)