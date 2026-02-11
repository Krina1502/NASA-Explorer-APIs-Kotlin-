package com.example.nasa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageSearchActivity : ComponentActivity() {

    private val viewModel: ImageSearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        val queryInput = findViewById<EditText>(R.id.queryInput)
        val searchBtn = findViewById<Button>(R.id.searchBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ImageSearchAdapter()
        recyclerView.adapter = adapter

        searchBtn.setOnClickListener {
            val query = queryInput.text.toString()
            viewModel.search(query)
            viewModel.results.observe(this) { results ->
                adapter.submitList(results)
            }
        }
    }
}
