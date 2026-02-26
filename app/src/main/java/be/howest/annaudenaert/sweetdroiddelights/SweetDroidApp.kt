package be.howest.annaudenaert.sweetdroiddelights

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.Screen
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidAppBar
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidBottomBar
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidNavGraph
import be.howest.annaudenaert.sweetdroiddelights.ui.theme.AppTheme

@Composable
fun SweetDroidApp(){
    AppTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backStackEntry?.destination
        val context = LocalContext.current

        Scaffold(
            modifier = Modifier.Companion.fillMaxSize(),
            topBar = {
                SweetDroidAppBar(
                    canNavigateBack = currentDestination?.route == Screen.DessertDetail.route,
                    navigateUp = { navController.navigateUp() },
                    shareWithFriends = { shareWithFriends(context) }
                )
            },
            bottomBar = {
                SweetDroidBottomBar(
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
        ) { innerPadding ->
            SweetDroidNavGraph(
                navController = navController,
                modifier = Modifier.Companion.padding(innerPadding)
            )
        }
    }
}

fun shareWithFriends(context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "SweetDroid Delights Shop")
        putExtra(Intent.EXTRA_TEXT, "Check out my favorite desserts place!")
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            "New share with friends"
        )
    )
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5,
)

@Composable
fun SweetDroidAppPreview() {
    AppTheme {
        SweetDroidApp()
    }
}