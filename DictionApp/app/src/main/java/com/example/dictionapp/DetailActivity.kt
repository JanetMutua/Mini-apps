package com.example.dictionapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionapp.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity()
{
    //defining constants to be used in this class and the LetterAdapter
    companion object
    {
        const val LETTER = "A"
    }

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val letterId = "A"
        recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(LETTER, this)


        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = getString(R.string.detail_prefix) + " " + LETTER



    }
}