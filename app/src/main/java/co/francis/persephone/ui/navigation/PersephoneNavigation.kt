package co.francis.persephone.ui.navigation

import androidx.navigation.NavHostController
import co.francis.persephone.ui.navigation.PersephoneDestinations.ADD_PLANT_ROUTE
import co.francis.persephone.ui.navigation.PersephoneDestinations.HOME_ROUTE

object PersephoneDestinations {
    const val HOME_ROUTE = "home"
    const val ADD_PLANT_ROUTE = "addPlant"
}

class PersephoneNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(HOME_ROUTE) {
            popUpTo(HOME_ROUTE)
            launchSingleTop = true
        }
    }

    fun navigateToAddPlant() {
        navController.navigate(ADD_PLANT_ROUTE) {
            popUpTo(ADD_PLANT_ROUTE)
            launchSingleTop = true
        }
    }
}