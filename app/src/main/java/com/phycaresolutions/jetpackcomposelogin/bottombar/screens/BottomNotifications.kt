package com.phycaresolutions.jetpackcomposelogin.bottombar.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.interaction.collectIsDraggedAsState
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.phycaresolutions.jetpackcomposelogin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun BottomNotifications() {
    Text(text = "this is screen   2")



    val pages = listOf(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground)
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()
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
       HorizontalPagerIndicator(pagerState = pagerState,
           pageCount = pages.size,
           modifier = Modifier
               .align(Alignment.CenterHorizontally)
               .padding(bottom = 10.dp),
           inactiveColor = colorResource(id = R.color.purple_200),
           activeColor = colorResource(id = R.color.purple_700)
           )
    }

    // Start auto-scroll effect
    LaunchedEffect(isDraggedState) {
        // convert compose state into flow
        snapshotFlow { isDraggedState.value }
            .collectLatest { isDragged ->
                // if not isDragged start slide animation
                if (!isDragged) {
                    // infinity loop
                    while (true) {
                        // duration before each scroll animation
                        delay(1_000L)
                        runCatching {
                            pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                        }
                    }
                }
            }
    }
}