package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun BottomSettings() {
    val list = listOf("Android","Java","Kotlin","Angular","Reactive","Python","Dot net","Java Script","IOS","Just In","Android","Java","Kotlin","Angular","Reactive","Python","Dot net","Java Script","IOS","Just In")
     Row {
         Column(modifier = Modifier
             .padding(top = 120.dp, start = 0.dp)
             .fillMaxHeight()
             .width(140.dp)
             .background(color = Color.White)
             .shadow(elevation = 5.dp),
             verticalArrangement = Arrangement.Top,
             horizontalAlignment = Alignment.Start) {
             LazyColumn(modifier = Modifier
                 .padding(start = 0.dp)
                 .align(Alignment.CenterHorizontally)) {
                 items(list.size){
                     Text(text = list[it])
                     Spacer(modifier = Modifier.padding(20.dp))
                 }
             }



         }

     }


}
