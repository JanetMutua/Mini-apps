package com.example.droppy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.droppy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//========================Setting up the Navigation drawer=================================================
        //initializing toggle
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        //connecting the toggle with the DrawerLayout
        binding.drawerLayout.addDrawerListener(toggle)
        //syncing the state on the toggle bar
        toggle.syncState()

        //enabling opening and closing of the menu bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //setting an onclick listener for the menu items
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.library -> Toast.makeText(this, "Opening Library...", Toast.LENGTH_SHORT).show()
                R.id.downloads -> Toast.makeText(this, "Checking for downloads...", Toast.LENGTH_SHORT).show()
                R.id.accounts -> Toast.makeText(this, "Account settings", Toast.LENGTH_SHORT).show()
            }
            true
        }

//========================================Setting up fragments======================================

        //setting the instances of the three fragments
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        //setting the current fragment
        switchFragments(firstFragment)

        //setting an onClickListener for the BottomNavigation
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.imHome -> switchFragments(firstFragment)
                R.id.imMessages -> switchFragments(secondFragment)
                R.id.imProfile -> switchFragments(thirdFragment)
            }
            //return true but do not include the keyword "return" since it is a lambda expression
            true
        }

        //setting the notifications icon on top of messages
        binding.bottomNavigationView.getOrCreateBadge(R.id.imMessages).apply {
            number = 25
            isVisible = true
        }

    }

    //inflating the menu bar on the app bar
    //enabling toggle action on the app bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    //function for switching fragments
    private fun switchFragments(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

}





