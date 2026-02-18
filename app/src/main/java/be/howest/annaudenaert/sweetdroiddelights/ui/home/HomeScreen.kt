package be.howest.annaudenaert.sweetdroiddelights.ui.home

import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import be.howest.annaudenaert.sweetdroiddelights.ui.theme.AppTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onEmailChanged: (String) -> Unit,
    onSubscribeClicked: () -> Unit,
    onOrderDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ShopImage()

        OrderButton(onOrderDessertClicked)

        ShopDescription()

        if (!uiState.isSubscribed) {
            SubscriptionComponent(
                email = uiState.emailAddress,
                onEmailChanged = onEmailChanged,
                onSubscribeClicked = onSubscribeClicked
            )
        } else {
            SubscribedComponent();
        }
    }
}

@Composable
fun ShopImage() {
    Image(
        painter = painterResource(id = R.drawable.sweetdroid_delight),
        contentDescription = stringResource(id = R.string.welcome_text),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun OrderButton(
    onOrderClicked: () -> Unit
) {
    Button(
        onClick = onOrderClicked,
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Text(text = stringResource(id = R.string.order_button_label))
    }
}

@Composable
fun ShopDescription() {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = stringResource(id = R.string.description_text),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SubscriptionComponent(
    email: String,
    onEmailChanged: (String) -> Unit,
    onSubscribeClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("subscribe"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.subscribe_title),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = email,
            onValueChange = onEmailChanged,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            label = { Text(stringResource(id = R.string.email_label)) },
            placeholder = { Text(stringResource(id = R.string.email_placeholder)) },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("email_input"),
            singleLine = true
        )

        Button(
            onClick = onSubscribeClicked,
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            enabled = email.isNotEmpty()
        ) {
            Text(text = stringResource(id = R.string.subscribe_button_label))
        }
    }
}

@Composable
fun SubscribedComponent() {
    Text(
        text = stringResource(id = R.string.subscribed_title),
        modifier = Modifier.padding(top = 24.dp),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            uiState = HomeUiState(),
            onEmailChanged = {},
            onSubscribeClicked = {},
            onOrderDessertClicked = {}
        )
    }
}