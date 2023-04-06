package com.example.dictionapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter (val letterId:String, context: Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    //setting up relevant data

    private var wordList:List<String>
     init {
         val words = context.resources.getStringArray(R.array.words).toList()
         wordList = words.filter { it.startsWith(letterId) }
             .sorted()
             .shuffled()
     }


    class WordViewHolder(view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return WordViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.button.text = word.toString()

    }
}