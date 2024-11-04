package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phycaresolutions.jetpackcomposelogin.R

@Preview(showBackground = true)
@Composable
fun TabScreen1() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(1.dp)
        .background(color = colorResource(id = R.color.purple_500))) {

    }


}