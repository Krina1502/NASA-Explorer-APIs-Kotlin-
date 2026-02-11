package com.example.nasa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MarsRoverActivity : ComponentActivity() {

    private val viewModel: MarsRoverViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_rover)

        val dateInput = findViewById<EditText>(R.id.dateInput)
        val fetchBtn = findViewById<Button>(R.id.fetchBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MarsPhotoAdapter()
        recyclerView.adapter = adapter

        fetchBtn.setOnClickListener {
            val date = dateInput.text.toString()
            viewModel.fetchPhotos(date)
            viewModel.photos.observe(this) { photos ->
                adapter.submitList(photos)
            }
        }
    }
}
