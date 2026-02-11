package be.howest.annaudenaert.sweetdroiddelights

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeScreen_showsOrderDessertButton(){
        composeTestRule
            .onNodeWithText("ORDER A DESSERT!")
            .assertIsDisplayed()
    }

    @Test
    fun homeScreen_isScrollable() {
        composeTestRule
            .onNodeWithTag("subscribe")
            .performScrollTo()
            .assertIsDisplayed()
    }
}