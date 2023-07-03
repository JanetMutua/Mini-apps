package com.example.littlelemonrestaurant

import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.littlelemonrestaurant.DishIngredients.Dish




fun TextView.printIngredients(dish:Dish){

    for (ingredient in dish.ingredients){
        val newText = "$text \n $ingredient"
        text = newText
    }

}

//extension function
//extend Context or ComponentActivity or Fragment

fun ComponentActivity.showToastMessage(text:String){
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Int.getAMount():String{
    if (this > 0)
        return this.toString()
    else
        return "Out of stock"
}

fun TextView.appendText(title:String){
    val newText = "$text \n $title"
    text = newText
}
