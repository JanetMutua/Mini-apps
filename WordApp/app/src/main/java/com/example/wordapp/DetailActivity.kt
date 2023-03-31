package com.example.wordapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(){

//    organizing the "letter constant" to make it accessible outside this Activity
    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

//      Retrieving binding object that lets you refer to views with their ID name
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      making each letter clicked return only words that start with that letter by:
//      Retrieving LETTER from the Intent extras instead of hardcoding letter A.
        val letterId = intent?.extras?.getString(LETTER).toString()


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