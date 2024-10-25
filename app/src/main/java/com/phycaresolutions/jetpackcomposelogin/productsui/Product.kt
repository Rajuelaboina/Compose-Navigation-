package com.phycaresolutions.jetpackcomposelogin.productsui

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "color")
    val color: Int,
    @ColumnInfo(name = "price")
    val price: Float,
    @ColumnInfo(name = "discountPrice")
    val discountPrice: Float,
    @ColumnInfo(name = "size")
    val size: Int,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "imageRes")
    @DrawableRes val imageRes: Int,
)
