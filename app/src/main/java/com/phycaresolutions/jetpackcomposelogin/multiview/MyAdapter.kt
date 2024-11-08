package com.phycaresolutions.jetpackcomposelogin.multiview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phycaresolutions.jetpackcomposelogin.R

class MyAdapter( val items : List<ListItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            0 -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_item_layout, parent, false)
            )
            1 ->TextViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.text_item_layout, parent, false)
                    )
            1 -> ImageViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.image_item_layout, parent, false)
                    )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ListItem.HeaderItem -> (holder as HeaderViewHolder).bind(item)
            is ListItem.TextItem -> (holder as TextViewHolder).bind(item)
            is ListItem.ImageItem -> (holder as ImageViewHolder).bind(item)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is ListItem.HeaderItem -> 0
            is ListItem.TextItem -> 1
            is ListItem.ImageItem -> 2
        }
    }

    inner class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: ListItem.HeaderItem) {

        }
    }
    inner class TextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: ListItem.TextItem) {

        }

    }
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: ListItem.ImageItem) {

        }
    }

}