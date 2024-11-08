package com.phycaresolutions.jetpackcomposelogin.multiview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.phycaresolutions.jetpackcomposelogin.R

class MainMultiViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main_multi_view)
       // setupRecyclerview()


    }
    fun setupRecyclerview(){
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        val list = listOf(
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

        val adapter = MyAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter
    }
}