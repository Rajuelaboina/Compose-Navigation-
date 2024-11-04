package com.phycaresolutions.jetpackcomposelogin.bottombar.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
            //val count =  DataBase.getInstance(context).productDao().getCarCount()
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
                /*actions = {
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

                    *//*IconButton(onClick =
                    {
                        //PreferencesManager(context).clearData(context)
                        // Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
                    })
                    {
                       Icon(Icons.Rounded.ShoppingCart, contentDescription = null, tint = Color.Black)
                    }*//*

                }*/


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
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val context = LocalContext.current
  //  val count =  DataBase.getInstance(context).productDao().getCarCount()
    NavigationBar(containerColor  = Color.White) {
        bottomNavigationItems.forEachIndexed  { index,item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                icon = {
                    //Icon(item.icon, contentDescription = null)
                    BadgedBox(badge = {
                         if (item.badgeCount != null){
                             Badge{
                                 var txt = ""
                                 if (item.label == "Cart" ){
                                          // txt = count.toString()
                                     txt = CartItem.cc.toString()
                                 }else{
                                      txt = item.badgeCount.toString()
                                 }
                                 Text(text = txt)

                             }
                         }else if (item.hasNews){
                             Badge()
                         }
                    } ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.icon
                            } else item.unselectedIcon,
                            contentDescription = item.label
                        )
                    }
                },
                label = { Text(text = item.label) },
                alwaysShowLabel = true,
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
    NavigationItem(BottomRoute.SCREEN_ONE, "Home", Icons.Default.Home,Icons.Outlined.Home,false,null),
    NavigationItem(BottomRoute.SCREEN_TWO, "screen 2", Icons.Default.Notifications,Icons.Outlined.Notifications,false,10),
    NavigationItem(BottomRoute.SCREEN_THREE, "screen 3", Icons.Default.Settings,Icons.Outlined.Settings,true,20),
    NavigationItem(BottomRoute.SCREEN_CART, "Cart", Icons.Default.ShoppingCart,Icons.Outlined.ShoppingCart,false,0),
)
