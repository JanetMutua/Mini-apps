package com.example.searchable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>(){

    //setting up my data for showcasing on the app
    val lettersList = 'A'.rangeTo('Z').toList()


    //holds an instance of the button view
    class LetterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layoutInflated = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return LetterViewHolder(layoutInflated)
    }

    override fun getItemCount(): Int {
        return lettersList.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = lettersList[position]
        holder.button.text = item.toString()
    }
}