package com.phycaresolutions.jetpackcomposelogin.productsui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phycaresolutions.jetpackcomposelogin.R
import com.phycaresolutions.jetpackcomposelogin.bottombar.navigation.BottomRoute

@Preview(showBackground = true)
@Composable
fun ProductsScreen(navController: NavController = rememberNavController()) {

    val products = remember {
        getProductList()
    }
    Column(modifier = Modifier

        .padding(top = 100.dp, bottom = 100.dp)) {
        LazyVerticalGrid(
            modifier = Modifier.padding(5.dp),
            columns = GridCells.Fixed(2),
        ) {
            items(products) {
                ProductItem(product = it) {
                    // navController.navigate("${NavigationItem.PRODUCT_DETAILS}/${it.id}")
                    navController.navigate("${BottomRoute.PRODUCT_DETAILS}/${it.id}")
                }
            }
        }
    }


}

fun getProductList(): List<Product>{
    return listOf(
        Product(
            id = 1,
            pid = 1,
            "Shoes - Pink 8",
            color = android.graphics.Color.MAGENTA,
            price = 1200f,
            discountPrice = 1100f,
            size = 8,
            rating = 4.5f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 2,
            "Shoes - Blue 10",
            color = android.graphics.Color.BLUE,
            price = 1300f,
            discountPrice = 1200f,
            size = 10,
            rating = 4.3f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 3,
            "Shoes - Green 11",
            color = android.graphics.Color.GREEN,
            price = 1400f,
            discountPrice = 1140f,
            size = 11,
            rating = 4.4f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 4,
            "Shoes - RED 10",
            color = android.graphics.Color.RED,
            price = 1300f,
            discountPrice = 1200f,
            size = 10,
            rating = 4.2f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 5,
            "Shoes - Yellow 9",
            color = android.graphics.Color.YELLOW,
            price = 1200f,
            discountPrice = 1000f,
            size = 9,
            rating = 4.0f,
            imageRes = R.drawable.ic_launcher_foreground
        ),
        Product(
            id = 0,
            pid = 6,
            "Shoes - Pink 8",
            color = android.graphics.Color.MAGENTA,
            price = 1200f,
            discountPrice = 1100f,
            size = 8,
            rating = 4.5f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 7,
            "Shoes - Blue 10",
            color = android.graphics.Color.BLUE,
            price = 1300f,
            discountPrice = 1200f,
            size = 10,
            rating = 4.3f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 8,
            "Shoes - Green 11",
            color = android.graphics.Color.GREEN,
            price = 1400f,
            discountPrice = 1140f,
            size = 11,
            rating = 4.4f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 9,
            "Shoes - RED 10",
            color = android.graphics.Color.RED,
            price = 1300f,
            discountPrice = 1200f,
            size = 10,
            rating = 4.2f,
            imageRes = R.drawable.ic_launcher_foreground
        ), Product(
            id = 0,
            pid = 10,
            "Shoes - Yellow 9",
            color = android.graphics.Color.YELLOW,
            price = 1200f,
            discountPrice = 1000f,
            size = 9,
            rating = 4.0f,
            imageRes = R.drawable.ic_launcher_foreground
        )
    )
}