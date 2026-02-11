package com.example.nasa

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.bumptech.glide.Glide

class APODActivity : ComponentActivity() {

    private val viewModel: APODViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)

        val imageView = findViewById<ImageView>(R.id.apodImage)
        val titleView = findViewById<TextView>(R.id.apodTitle)
        val descView = findViewById<TextView>(R.id.apodDesc)

        viewModel.apodData.observe(this) { apod ->
            titleView.text = apod.title
            descView.text = apod.explanation
            Glide.with(this).load(apod.url).into(imageView)
        }
    }
}
