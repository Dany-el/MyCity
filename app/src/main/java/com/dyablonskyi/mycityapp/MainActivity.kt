package com.dyablonskyi.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dyablonskyi.mycityapp.data.Category
import com.dyablonskyi.mycityapp.data.coffees
import com.dyablonskyi.mycityapp.data.parks
import com.dyablonskyi.mycityapp.data.restaurants
import com.dyablonskyi.mycityapp.data.shoppingCenters
import com.dyablonskyi.mycityapp.presentation.Categories
import com.dyablonskyi.mycityapp.presentation.Coffee
import com.dyablonskyi.mycityapp.presentation.Park
import com.dyablonskyi.mycityapp.presentation.Restaurant
import com.dyablonskyi.mycityapp.presentation.ShoppingCenter
import com.dyablonskyi.mycityapp.presentation.screens.CategoryScreen
import com.dyablonskyi.mycityapp.presentation.screens.PlaceScreen
import com.dyablonskyi.mycityapp.presentation.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityAppTheme {
                MyCityApp()
            }
        }
    }
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        tonalElevation = 5.dp
    ) {
        MyCityNavHost(navController = navController)
    }
}

@Composable
fun MyCityNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Categories.route,
        modifier = modifier
    ){
        composable(route = Categories.route){
            CategoryScreen{ category ->
                val destination = when(category){
                    Category.COFFEE_SHOP -> Coffee.route
                    Category.RESTAURANT -> Restaurant.route
                    Category.PARK -> Park.route
                    Category.SHOPPING_CENTER -> ShoppingCenter.route
                }
                navController.navigateSingleTopTo(destination)
            }
        }
        composable(route = Coffee.route){
            PlaceScreen(places = coffees)
        }

        composable(route = Restaurant.route){
            PlaceScreen(places = restaurants)
        }

        composable(route = Park.route){
            PlaceScreen(places = parks)
        }

        composable(route = ShoppingCenter.route){
            PlaceScreen(places = shoppingCenters)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        launchSingleTop = true
    }