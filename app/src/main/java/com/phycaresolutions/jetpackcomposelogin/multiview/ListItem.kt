package com.phycaresolutions.jetpackcomposelogin.multiview

sealed class ListItem {
    data class HeaderItem(val str:String):ListItem()
    data class TextItem(val str:String):ListItem()
    data class ImageItem(val imageurl: String):ListItem()
}