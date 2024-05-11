package co.francis.persephone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.francis.persephone.ui.addplant.AddPlantScreen
import co.francis.persephone.ui.home.HomeScreen

@Composable
fun PersephoneNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PersephoneDestinations.HOME_ROUTE,
    navigationActions: PersephoneNavigationActions = remember(navController) {
        PersephoneNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(PersephoneDestinations.HOME_ROUTE) {
            HomeScreen(
                onAddPlantClick = {
                    navigationActions.navigateToAddPlant()
                }
            )
        }
        composable(PersephoneDestinations.ADD_PLANT_ROUTE) {
            AddPlantScreen(
                onPlantAdded = {
                    navigationActions.navigateToHome()
                }
            )
        }
    }

}