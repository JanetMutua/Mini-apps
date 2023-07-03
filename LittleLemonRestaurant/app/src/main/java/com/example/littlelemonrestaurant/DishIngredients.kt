package com.example.littlelemonrestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DishIngredients : AppCompatActivity() {

    class Dish(
        val dishName:String,
        val ingredients:MutableList<String>
    )

    val ramen = Dish("Ramen", mutableListOf("Pasta", "Soy sauce", "Eggs","Kimchi"))
    val chickenBurgers = Dish("Chicken Burgers", mutableListOf("Chicken patties", "Mayonnaise", "Eggs", "Cheese"))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_ingredients)


        val message = intent.getStringExtra(DISH_NAME_KEY)

        when(message){
            ramen.dishName -> findViewById<TextView>(R.id.textView).printIngredients(ramen)
            chickenBurgers.dishName -> findViewById<TextView>(R.id.textView).printIngredients(chickenBurgers)
            else -> "Unknown ingredients"
        }

    }

    companion object{
        const val DISH_NAME_KEY = "DishName"

        fun start(context: Context, dishName:String){
            val intent = Intent(context, DishIngredients::class.java).apply { putExtra(DISH_NAME_KEY, dishName)}
            context.startActivity(intent)
        }


    }
}