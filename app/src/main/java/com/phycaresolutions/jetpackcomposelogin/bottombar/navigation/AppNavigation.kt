package com.phycaresolutions.jetpackcomposelogin.bottombar.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.phycaresolutions.jetpackcomposelogin.bottombar.screens.BottomNotifications
import com.phycaresolutions.jetpackcomposelogin.bottombar.screens.BottomSettings
import com.phycaresolutions.jetpackcomposelogin.productsui.ProductDetailsScreen
import com.phycaresolutions.jetpackcomposelogin.productsui.ProductsScreen


@Composable
fun AppNavigation (navController: NavHostController, padding: PaddingValues){
    NavHost(navController = navController, startDestination = BottomRoute.SCREEN_ONE) {
        composable(BottomRoute.SCREEN_ONE){
           // BottomHome(navController)
            ProductsScreen(navController)
        }
        composable(BottomRoute.SCREEN_TWO){ BottomNotifications()}
        composable(BottomRoute.SCREEN_THREE){ BottomSettings()}
        composable(BottomRoute.PRODUCT_DETAILS+"/{productId}", arguments = listOf(
            navArgument("productId"){
                type = NavType.StringType
            }
        )) {
            val productId = it.arguments?.getString("productId")
            if (productId!=null)
                ProductDetailsScreen(productId = productId, navController = navController)
        }

    }

}


