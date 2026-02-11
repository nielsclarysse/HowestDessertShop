package be.howest.annaudenaert.sweetdroiddelights.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.howest.annaudenaert.sweetdroiddelights.R
import be.howest.annaudenaert.sweetdroiddelights.ui.theme.AppTheme

@Composable
fun HomeScreen(
    onOrderDessertClick: () -> Unit,
    onSubscribeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ShopImage()
        OrderButton(onOrderDessertClick)
        ShopDescription()
    }
}

@Composable
fun ShopImage() {
    Image(
        painter = painterResource(id = R.drawable.sweetdroid_delight),
        contentDescription = "This is an image of the shop!",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun OrderButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Text(text = "ORDER A DESSERT!")
    }
}

@Composable
fun ShopDescription() {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = "Craving something sweet? You’ve come to the right place! At SweetDroid Delights, we serve up the most delicious treats, from fluffy cupcakes to crunchy KitKats, all with an extra touch of Android magic.",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = "Tap, swipe, and indulge—because every dessert is a byte-sized delight!",
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = "Go ahead, treat yourself! Your perfect snack is just a tap away.",
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            onOrderDessertClick = {},
            onSubscribeClick = {}
        )
    }
}
