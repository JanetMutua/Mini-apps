package com.example.bottombar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottombar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //removing the shadow effect on the BottomNavigationView
        binding.bottomNavigationView.background = null

        //making the placeholder menu item unclickable
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
    }
}