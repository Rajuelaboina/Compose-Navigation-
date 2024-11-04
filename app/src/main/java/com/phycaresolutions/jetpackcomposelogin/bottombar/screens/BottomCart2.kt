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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
fun BottomCart2() {
    val tablist = listOf("Android", "Kotlin", "Java", "Angular", "Reactive", "JS")
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var tabIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 100.dp),
        verticalArrangement = Arrangement.Top
    )
    {


        val tabData = listOf(
            "Android" to Icons.Default.Home,
            "Kotlin" to Icons.Default.Person,
            "Java" to Icons.Default.Notifications,
            "Angular" to Icons.Default.Home,
            "Reactive" to Icons.Default.Person,
            "JavaScript" to Icons.Default.Notifications
        )

        Column {
            TabRow(selectedTabIndex = tabIndex) {
                tabData.forEachIndexed { index, pair ->
                    Tab(selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(text = pair.first) },
                        icon = { Icon(imageVector = pair.second, contentDescription = null) }
                    )
                }
            }

            // Tab content

            when (tabIndex) {
                0 -> HomeScreen2()
                1 -> DashboardScreen()
                2 -> NotificationsScreen()
            }


        }

    }
}
@Composable
fun HomeScreen3() {
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
fun DashboardScreen3() {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Dashboard Screen")
    }
}

@Composable
fun NotificationsScreen3() {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Notifications Screen")
    }
}
