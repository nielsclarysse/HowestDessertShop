package be.howest.annaudenaert.sweetdroiddelights.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import be.howest.annaudenaert.sweetdroiddelights.R
import com.google.android.engage.shopping.datamodel.ShoppingCart

@Composable
fun SweetDroidBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                label = { Text(stringResource(id = screen.labelResourceId)) },
                icon = {
                    BadgedBox(
                        badge = {
                            if (screen.route == Screen.ShoppingCart.route) {
                                Badge { Text("3") } //aantal items in winkelmand, dit maken we later dynamisch op basis van de data
                            }
                        }
                    ) {
                        Icon(screen.icon, contentDescription = null)
                    }
                }
            )
        }
    }
}
