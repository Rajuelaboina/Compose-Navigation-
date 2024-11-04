package com.phycaresolutions.jetpackcomposelogin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.phycaresolutions.jetpackcomposelogin.productsui.Product

@Dao
interface ProductDao {
    @Insert
    fun insert(product: Product):Long
    @Query("SELECT COUNT (*) FROM product")
    fun getCarCount():Int
    @Query("SELECT * FROM product")
    fun getAllProduct():List<Product>
}