package com.example.littlelemonrestaurant

class PriceCalculator{
    fun calculateMealPrice(
        item1:Double,
        item2:Double,
        taxAmount:Double
    ):Double{
        return (item1 + item2) * (1.0 + taxAmount)
    }
}