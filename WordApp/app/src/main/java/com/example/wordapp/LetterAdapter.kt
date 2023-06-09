package com.example.wordapp

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>(){

//  initializing the app's data that is: a list of words from A to Z
    private val list = ('A').rangeTo('Z').toList()


//  initializing class for the LetterViewHolder(gives a reference to the button view
    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_view)
    }


//  creating the ViewHolder for the item_view layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        layout.accessibilityDelegate = Accessibility
        return LetterViewHolder(layout)
    }


//  Getting the size of list
    override fun getItemCount(): Int {
        return list.size
    }


//  Replace the content on the View Holder with new Data
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()


//      creating a setOnClickListener for the button to enable it to move to a different activity
        holder.button.setOnClickListener {
            val action = LetterListFragmentDirections
                .actionLetterListFragmentToWordListFragment(
                    letter = holder.button.text.toString()
                )

            holder.view.findNavController().navigate(action)
        }



    }


//  defining custom accessibility
    companion object Accessibility: View.AccessibilityDelegate(){
        override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(host, info)

            val customString = host.context?.getString(R.string.look_up_words)

            val customClick = AccessibilityNodeInfo.AccessibilityAction(
                AccessibilityNodeInfo.ACTION_CLICK,
                customString
            )
            info.addAction(customClick)
        }
    }
}