package be.howest.annaudenaert.sweetdroiddelights.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import be.howest.annaudenaert.sweetdroiddelights.R

@Composable
fun SweetDroidBottomBar(
    onHomeClick: () -> Unit,
    onDessertsClick: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = stringResource(R.string.home_label)) },
            label = { Text(stringResource(R.string.home_label)) }
        )

        NavigationBarItem(
            selected = false,
            onClick = onDessertsClick,
            icon = { Icon(Icons.Default.Search,contentDescription = stringResource(R.string.shop_label)) },
            label = { Text(stringResource(R.string.home_label)) }
        )
    }
}
