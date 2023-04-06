package com.example.dictionapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionapp.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId: String = "A"
        recyclerView = binding.recyclerView

        recyclerView.adapter = WordAdapter(letterId, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}