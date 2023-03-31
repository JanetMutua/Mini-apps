package com.example.wordapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val letterId:String, context: Context)
    : RecyclerView.Adapter<WordAdapter.WordViewHolder>(){


//  initializing filteredWords variable for assigning a filtered and shuffled list of words
    private val filteredWords:List<String>


//  assigning values for the array of words to the previously initialized filteredWords variable
    init {
        val words = context.resources.getStringArray(R.array.words).toList()
        filteredWords = words
            .filter { it.startsWith(letterId, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }


//  initializing a ViewHolder class and initializing a button variable from the list_view layout
    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_view)
    }


//  creating a ViewHolder for the list_view layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return WordViewHolder(layout)
    }


//   Obtaining the list size of filteredWords
    override fun getItemCount(): Int = filteredWords.size


//   Binding the viewHolder to the necessary data
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = filteredWords[position]
        val context = holder.view.context
//    setting the text of the WordViewHolder
        holder.button.text = item
        holder.button.setOnClickListener {
            val queryUrl:Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_SEARCH, queryUrl)
            context.startActivity(intent)
        }
    }


//  setting up accessibility
    companion object Accessibility: View.AccessibilityDelegate(){

        override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(host, info)

            val customString = host.context?.getString(R.string.look_up_word)

            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info.addAction(customClick)
        }
    }
}
