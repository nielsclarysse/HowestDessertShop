package be.howest.annaudenaert.sweetdroiddelights.ui.desserts

import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.howest.annaudenaert.sweetdroiddelights.R
import be.howest.annaudenaert.sweetdroiddelights.domain.model.Dessert
import be.howest.annaudenaert.sweetdroiddelights.ui.home.HomeUiState
import be.howest.annaudenaert.sweetdroiddelights.ui.theme.AppTheme

@Composable
fun DessertListScreen(
    uiState: DessertListUiState,
    onDessertClicked: (Dessert) -> Unit,
    modifier: Modifier = Modifier
) {
    DessertList(
        uiState = uiState,
        onDessertClicked = onDessertClicked,
        modifier = modifier
    )
}

@Composable
fun DessertList(
    uiState: DessertListUiState,
    onDessertClicked: (Dessert) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("dessertGrid")
    ) {
        // Span on two will stretch 2 columns.
        item(span = { GridItemSpan(1) }) {
            ShopLabel()
        }

        item(span = { GridItemSpan(1) }) {
            FreeShipping()
        }

        items(uiState.desserts) { dessert ->
            DessertItemCard(
                dessert = dessert,
                onDessertClicked = onDessertClicked
            )
        }
    }
}

@Composable
fun ShopLabel() {
    Text(
        text = stringResource(R.string.dessert),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun FreeShipping() {
    ElevatedCard (
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.free_shipping),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DessertItemCard(
    dessert: Dessert,
    onDessertClicked: (Dessert) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onDessertClicked(dessert) },
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = dessert.imageFile),
                contentDescription = dessert.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Fit
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = dessert.name,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${dessert.price}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DessertListScreenPreview() {
    AppTheme {
        DessertListScreen (
            uiState = DessertListUiState(),
            onDessertClicked = {}
        )
    }
}