package com.phycaresolutions.jetpackcomposelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.phycaresolutions.jetpackcomposelogin.multiview.ListItem
import com.phycaresolutions.jetpackcomposelogin.ui.theme.JetPackComposeLoginTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeLoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                     val dataItems = (0..100).map {
                            if (it%2==0){
                               ItemTypeOne ("this is multi type view One!")
                            }else{
                                   ItemTypeTwo("this is type tw0","this is type 2 para")
                            }

                     }
                    val list =listOf(
                        ListItem.HeaderItem("Header 1"),
                        ListItem.TextItem("Text Item 1"),
                        ListItem.TextItem("Text Item 2"),
                        ListItem.ImageItem("https://loremflickr.com/320/240"),
                        ListItem.HeaderItem("Header 2"),
                        ListItem.TextItem("Text Item 3"),
                        ListItem.TextItem("Text Item 4"),
                        ListItem.ImageItem("https://loremflickr.com/320/240"),
                        ListItem.HeaderItem("Header 3"),
                        ListItem.ImageItem("https://loremflickr.com/320/240"),
                        ListItem.ImageItem("https://loremflickr.com/320/240"),
                    )
                    MyMultipleItemList(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        list,
                    )
                 //   AIzaSyCeguW2kOE2_6vd0Izuk6jly_GrwhfJ9SA
                }
            }
        }
    }
   // https://www.google.com/maps/search/?api=AIzaSyCeguW2kOE2_6vd0Izuk6jly_GrwhfJ9SA&query=17.4065,78.4772
  // "https://www.google.com/maps/search/?api=1&query="+address;
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JetPackComposeLoginTheme {
        Greeting("Android")
    }
}
sealed class DataItem
data class ItemTypeOne(val text: String) : DataItem()
data class ItemTypeTwo(
    val text: String,
    val description: String,
) : DataItem()

@Composable
fun MyMultipleItemList(
    modifier: Modifier = Modifier,
    dataItems: List<ListItem>,
) {
    LazyColumn(modifier = modifier) {
        items(dataItems) { data ->
            when (data) {
                is ListItem.HeaderItem -> ItemOne(itemTypeOne = data)
                is ListItem.TextItem -> ItemTwo(itemTypeTwo = data)
                else -> {}
            }
        }
    }
}

@Composable
fun ItemOne(itemTypeOne: ListItem) {
    val vv = itemTypeOne

    Text(text = itemTypeOne.toString())
}

@Composable
fun ItemTwo(itemTypeTwo: ListItem) {

    Column {
        Text(text = itemTypeTwo.toString())
        Text(text = itemTypeTwo.toString())
    }
}