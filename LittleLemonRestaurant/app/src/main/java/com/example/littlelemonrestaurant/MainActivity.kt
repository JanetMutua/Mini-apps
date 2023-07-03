package com.example.littlelemonrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
           DishIngredients.start(this, "Ramen")
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            DishIngredients.start(this, "Chicken Burgers")
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            ProductAvailability.checkQuantity(this)
        }

        showToastMessage("Welcome to the ordering app!!!")

    }


}