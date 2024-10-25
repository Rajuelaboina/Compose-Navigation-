package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.phycaresolutions.jetpackcomposelogin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun BottomNotifications() {
    Text(text = "this is screen   2")



    val pages = listOf(R.drawable.s_1,R.drawable.s_2,R.drawable.s_3,R.drawable.s_4,R.drawable.s_5,R.drawable.s_6,R.drawable.s_7)
    val pagerState = rememberPagerState(pageCount = { pages.size })

    var pageSize by remember { mutableStateOf(IntSize.Zero) }
    val lastIndex by remember(pagerState.currentPage) {
        derivedStateOf { pagerState.currentPage == pages.size - 1 }
    }
    Column(modifier = Modifier
        .background(color = Color.LightGray)
        .fillMaxSize()
        .padding(top = 100.dp)
    ){

        HorizontalPager(
            state = pagerState) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Page Index : $it", color = Color.White,
                    fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace)
                Image(painterResource(id = pages[it]) , contentDescription ="" )
            }
        }
       HorizontalPagerIndicator(pagerState = pagerState, pageCount = pages.size,
           modifier = Modifier
               .align(Alignment.CenterHorizontally)
               .padding(bottom = 10.dp),)




    }
    /*LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            pagerState.animateScrollBy(
                value = if (lastIndex) -(pageSize.width.toFloat() * pages.size) else pageSize.width.toFloat(),
                animationSpec = tween(if (lastIndex) 2000 else 1400)
            )
        }
    }*/
    LaunchedEffect(Unit) {
        snapshotFlow { pagerState.currentPage }
            .debounce(2000L)
            .onEach {
                pagerState.animateScrollBy(
                    value = if (lastIndex) - (pageSize.width.toFloat() * pages.size) else pageSize.width.toFloat(),
                    animationSpec = tween(if (lastIndex) 2000 else 1400)
                )
            }
            .launchIn(this)
    }
}