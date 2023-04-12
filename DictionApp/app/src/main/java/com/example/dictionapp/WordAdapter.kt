package com.example.dictionapp

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class WordAdapter (private val letterId:String, context: Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    //setting up relevant data

    private val wordList:List<String>
     init {
         val words = context.resources.getStringArray(R.array.words).toList()
         wordList = words.filter { it.startsWith(letterId, ignoreCase = true) }
             .shuffled()
             .take(5)
             .sorted()
     }


    class WordViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        layout.accessibilityDelegate = Accessibility
        return WordViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        val context = holder.view.context
        holder.button.text = word

    }

    companion object Accessibility: View.AccessibilityDelegate(){

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
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