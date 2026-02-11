package com.example.nasa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MarsPhotoAdapter : RecyclerView.Adapter<MarsPhotoAdapter.PhotoViewHolder>() {

    private var photos: List<MarsRoverPhoto> = listOf()

    fun submitList(list: List<MarsRoverPhoto>) {
        photos = list
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.marsImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mars_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        Glide.with(holder.itemView).load(photos[position].img_src).into(holder.image)
    }

    override fun getItemCount() = photos.size
}
