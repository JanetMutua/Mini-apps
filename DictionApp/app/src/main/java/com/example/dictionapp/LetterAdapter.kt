package com.example.dictionapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    //creating my data set

    private val letterList = ('A').rangeTo('Z').toList()

    class LetterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate( R.layout.item_layout, parent, false)

        return LetterViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return letterList.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = letterList[position]
        holder.button.text = letter.toString()
    }
}