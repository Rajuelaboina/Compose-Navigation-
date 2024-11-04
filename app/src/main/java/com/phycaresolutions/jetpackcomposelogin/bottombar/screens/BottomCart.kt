package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.room.util.TableInfo


@Composable
fun BottomCart() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 100.dp),
        verticalArrangement = Arrangement.Top
    )
    {
         val tabs = listOf(
            TabItem("Home", Icons.Filled.Home),
            TabItem("Favorites", Icons.Filled.Favorite),
            TabItem("Profile", Icons.Filled.Person),
            TabItem("Add", Icons.Filled.Add),
            TabItem("Add", Icons.Filled.Settings),
            TabItem("Add", Icons.Filled.Email),
            TabItem("Add", Icons.Filled.Call)
        )
        Column {
              ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                edgePadding = 16.dp,
                modifier = Modifier.background(Color.White),
                contentColor = Color.Gray,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        color = Color.Black,
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .fillMaxWidth()
                    )
                }
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier.padding(8.dp),
                        content = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = tab.title,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = tab.title,
                                    modifier = Modifier
                                        .padding(8.dp),
                                    color = if (selectedTabIndex == index) Color.Black else Color.Gray
                                )
                            }
                        }
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> {
                    //Composible for tab1
                   // HomeScreen2()
                    TabScreen1()
                }
                1 -> {
                    //Composible for tab2
                    DashboardScreen()
                }
                2 -> {
                    //Composible for tab3
                     NotificationsScreen()
                }
                3 -> {
                    //Composible for tab4
                    HomeScreen2()
                }
                4 ->{
                    HomeScreen2()
                }
                5 ->{
                    HomeScreen2()
                }
                6 ->{
                    NotificationsScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen2() {
    var offset = remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offset.value += delta
                },
                onDragStopped = {
                    if (offset.value > 50) {
                        // TODO - switch to next tab
                    } else if (offset.value < -50) {
                        // TODO - switch to previous tab
                    }
                    offset.value = 0f
                }
            ),
    ) {
        Text("Home Screen")
    }
}

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Dashboard Screen")
    }
}

@Composable
fun NotificationsScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Notifications Screen")
    }
}
data class TabItem(val title:String, val icon: ImageVector)