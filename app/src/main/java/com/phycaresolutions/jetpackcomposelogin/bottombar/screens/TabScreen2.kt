package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phycaresolutions.jetpackcomposelogin.R

@Preview(showBackground = true)
@Composable
fun TabScreen1() {
    val list = listOf(R.drawable.s_1,R.drawable.s_2,R.drawable.s_3,R.drawable.ic_launcher_foreground,
        R.drawable.doctor,
        R.drawable.s_4,R.drawable.s_5,R.drawable.s_6,R.drawable.s_7,R.drawable.s_8)
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(1.dp)
        .background(color = colorResource(id = R.color.ash))) {

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
           items(list.size){
               Text(text = list[it].toString())
               Image(painterResource(id = list[it]), contentDescription ="" )

           }
        }

    }


}