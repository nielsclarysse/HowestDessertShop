package be.howest.annaudenaert.sweetdroiddelights

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.howest.annaudenaert.sweetdroiddelights.ui.navigation.SweetDroidNavGraph
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Before
    fun setupSweetDroidNavGraph() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            SweetDroidNavGraph(navController = navController)
        }
    }

    @Test
    fun sweetDroidNavGraph_verifiyHomeStartDestination(){
        composeTestRule
            .onNodeWithTag("home_screen")
            .assertIsDisplayed()
    }

    /*@Test
    fun sweetDroidNavGraph_navigateToDesserts(){
        composeTestRule.onNodeWithTag("order_dessert_btn")
            .performScrollTo()
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "desserts")
    }*/
}