package com.phycaresolutions.jetpackcomposelogin


import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.BottomNavScreen
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.BottomRoute
import com.phycaresolutions.jetpackcomposelogin.productsui.NavigationItem
import com.phycaresolutions.jetpackcomposelogin.productsui.ProductDetailsScreen
import com.phycaresolutions.jetpackcomposelogin.productsui.ProductsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = BottomRoute.LOGIN,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(400)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(400)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(400)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(400)
            )
        }
        ) {
        composable(BottomRoute.LOGIN) {
           // ProductsScreen(navController)
            LoginScreen(navController)
        }
        composable(BottomRoute.HOME) {
            BottomNavScreen()
        }
      /*  composable(NavigationItem.PRODUCT) {
            ProductsScreen(navController)
          //  BottomNavScreen()
        }
        composable(NavigationItem.PRODUCT_DETAILS+"/{productId}", arguments = listOf(
              navArgument("productId"){
                  type = NavType.StringType
              }
        )) {
            val productId = it.arguments?.getString("productId")
            if (productId!=null)
           ProductDetailsScreen(productId = productId, navController = navController)
        }
        composable(BottomRoute.HOME) {
            BottomNavScreen()
        }*/

    }
}