package navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import screens.Home

@Composable
fun SetupNavigation() {
    Navigator(
        screen = Home("Home")
    ){navigator ->

        SlideTransition(navigator=navigator)

    }
}