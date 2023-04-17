package com.example.searchable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var isLinearLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        chooseLayout()
    }

    //function that sets the layout to either grid or linear depending on whether isLinearLayout is true
    fun chooseLayout(){
        if (isLinearLayout){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }else {
            recyclerView.layoutManager = GridLayoutManager(this, 5)
        }

        recyclerView.adapter = LetterAdapter()
    }

    //function to set icon for the menu item
    fun setIcon(menuItem:MenuItem?){
       if (menuItem == null)
           return

       menuItem.icon =
            if (isLinearLayout){
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout_drawable)
            } else {
                ContextCompat.getDrawable(this, R.drawable.ic_linear_layout_drawable)
            }
    }

    //function for inflating the menu and calls the setIcon() function
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val menuItem = menu?.findItem(R.id.menu_item)

        setIcon(menuItem)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.menu_item -> {
                isLinearLayout = !isLinearLayout
                chooseLayout()
                setIcon(item)
                return true
            }

            else ->  super.onOptionsItemSelected(item)
        }

    }
}