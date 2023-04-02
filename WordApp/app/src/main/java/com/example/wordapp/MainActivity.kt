package com.example.wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerView

        layoutToggle()
    }

//  setting up the menu on the action button
    private var isLinearLayout = true

//  creating a function that toggles the layout into grid or list view based on current state
    private fun layoutToggle(){

        if (isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }

        recyclerView.adapter = LetterAdapter()
    }


//  function that sets the menu icon
    private fun setIcon(menuItem: MenuItem?){
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayout)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }


//  inflating the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val menuItem = menu?.findItem(R.id.action_switch_layout)
        setIcon(menuItem)
        return true
    }


//  function that sets the actual layout and calls the layoutToggle() function
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_switch_layout -> {
                isLinearLayout = !isLinearLayout
                layoutToggle()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}