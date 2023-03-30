package com.example.wordapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordapp.adapter.WordAdapter
import com.example.wordapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      Retrieving binding object that lets you refer to views with their ID name
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Retrieving LETTER from the Intent extras
        val letterId = "A"

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

//      adding a divider decoration between items

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = getString(R.string.detail_prefix) + " " + letterId


    }
}