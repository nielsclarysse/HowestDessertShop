package be.howest.annaudenaert.sweetdroiddelights

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidAppBar
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidBottomBar
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidNavGraph
import be.howest.annaudenaert.sweetdroiddelights.ui.theme.AppTheme

@Composable
fun SweetDroidApp(){
    AppTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.Companion.fillMaxSize(),
            topBar = {
                SweetDroidAppBar(
                    appName = R.string.app_name
                )
            },
            bottomBar = {
                SweetDroidBottomBar(
                    onHomeClick = {
                        navController.navigate("home"){
                            popUpTo("home") {inclusive = true}
                        }
                    },
                    onDessertsClick = {
                        navController.navigate("desserts")
                    }
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