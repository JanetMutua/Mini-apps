package com.example.dictionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var isLinearLayout = true
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        chooseLayout()

    }

    //setting the menubar and configuring change of layouts
    //setting the layouts
    private fun chooseLayout() {
        if (isLinearLayout) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    //assigning the different icons that are vector assets to different layouts
    fun setIcon(menuItem:MenuItem?){
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayout){
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            } else {
                ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
            }

    }

    //inflating the menu resource
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflate the menu resource
        menuInflater.inflate(R.menu.layout_menu, menu)

        val menuItem = menu?.findItem(R.id.layout_menu)
        setIcon(menuItem)
        return true
    }

    //setting the layout and calling the adapter

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.layout_menu -> {
                isLinearLayout = !isLinearLayout
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}