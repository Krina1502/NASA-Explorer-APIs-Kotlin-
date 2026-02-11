package com.example.nasa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageSearchAdapter : RecyclerView.Adapter<ImageSearchAdapter.ImageViewHolder>() {

    private var items: List<ImageSearchResult> = listOf()

    fun submitList(list: List<ImageSearchResult>) {
        items = list
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.searchImage)
        val title = itemView.findViewById<TextView>(R.id.searchTitle)
        val desc = itemView.findViewById<TextView>(R.id.searchDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_search, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.desc.text = item.description
        Glide.with(holder.itemView).load(item.imageUrl).into(holder.image)
    }

    override fun getItemCount() = items.size
}
