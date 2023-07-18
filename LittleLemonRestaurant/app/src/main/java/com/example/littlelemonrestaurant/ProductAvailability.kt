package com.example.littlelemonrestaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class ProductAvailability : AppCompatActivity() {

    val products = listOf(
        Product("Ramen", 20, 20.0),
        Product("Chicken Burger", 16, 45.0),
        Product("Pizza", 4, 30.0),
        Product("Loaded fries", 5, 12.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_availability)


        for (product in products){
            findViewById<TextView>(R.id.productView)
                .appendText("${product.title} (${product.quantity.getAMount()})")

        }
    }

    data class Product(val title:String, val quantity:Int, var price:Double){

        fun applyDiscount(discountPercent: Int){
            if(quantity > 0 && quantity <= 5){
                price -= (price * discountPercent/100)
            }
        }
    }

    companion object{

        fun checkQuantity(context: Context){
            val intent = Intent(context, ProductAvailability::class.java)
            context.startActivity(intent)
        }
    }
}