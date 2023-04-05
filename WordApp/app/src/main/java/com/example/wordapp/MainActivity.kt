package com.example.wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.wordapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        //ensuring action bar buttons like the menu option are visible

        setupActionBarWithNavController(navController)
    }

    //implementing onSupportNavigateUp() to allow handling of the up button

    override fun onSupportNavigateUp(): Boolean {
        //short circuit evaluation - if the left side returns false then the right side runs and vice versa
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}