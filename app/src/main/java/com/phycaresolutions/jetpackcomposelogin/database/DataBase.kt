package com.phycaresolutions.jetpackcomposelogin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.phycaresolutions.jetpackcomposelogin.productsui.Product

@Database(entities = [Product::class], version = 2)
abstract class DataBase:RoomDatabase() {

    abstract fun productDao(): ProductDao
    companion object{
        var databaseInstance: DataBase? = null
        fun getInstance(context: Context):DataBase{
            if(databaseInstance == null){
                databaseInstance = Room.databaseBuilder(context.applicationContext,
                    DataBase::class.java,"user_dataBase")
                    //.fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
            return databaseInstance!!
        }
    }

}