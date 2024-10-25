package com.phycaresolutions.jetpackcomposelogin.bottombar.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Database
import com.phycaresolutions.jetpackcomposelogin.R
import com.phycaresolutions.jetpackcomposelogin.database.DataBase


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute = navBackStackEntry?.destination?.route?:BottomRoute.SCREEN_ONE

    val context = LocalContext.current.applicationContext
    Scaffold(
        topBar = {
            val count =  DataBase.getInstance(context).productDao().getCarCount()
            TopAppBar(
                title = { Text(currentRoute, fontSize = 18.sp) },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription =
                        stringResource(id = R.string.app_name),
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                //navController.popBackStack()
                            }
                    )
                },
                /*colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                ),*/
                actions = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        BadgedBox(
                            badge = {
                                    Badge(
                                        containerColor = Color.Red,
                                        contentColor = Color.White
                                    ) {
                                        Text(count.toString(), textAlign = TextAlign.Start, fontSize = 14.sp)
                                    }

                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Shopping cart",
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }
                    }

                    /*IconButton(onClick =
                    {
                        //PreferencesManager(context).clearData(context)
                        // Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                    })
                    {
                       Icon(Icons.Rounded.ShoppingCart, contentDescription = null, tint = Color.Black)
                    }*/

                }


            ) //
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },

    ) { padding ->
        AppNavigation(navController = navController, padding = padding)
    }

}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(containerColor  = Color.White) {
        bottomNavigationItems.forEach { item ->
            NavigationBarItem(selected = currentRoute == item.route,
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(text = item.label) },
                onClick = {
                    // if (currentRoute != item.route){
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                    // }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = colorResource(id = R.color.purple_700),
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor = colorResource(id = R.color.purple_700)
                ),
            )
        }

    }
}

val bottomNavigationItems = listOf(
    NavigationItem(BottomRoute.SCREEN_ONE, "screen 1", Icons.Default.Home),
    NavigationItem(BottomRoute.SCREEN_TWO, "screen 2", Icons.Default.Notifications),
    NavigationItem(BottomRoute.SCREEN_THREE, "screen 3", Icons.Default.Settings),
)
