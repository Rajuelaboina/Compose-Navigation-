package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.phycaresolutions.jetpackcomposelogin.R
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.bottomNavigationItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomHome(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(10){
                  Text(text = "item"+it)
            }
        }
    }
}