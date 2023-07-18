package com.example.littlelemonrestaurant

import junit.framework.TestCase.assertEquals
import org.junit.Test


internal class ProductAvailabilityTest{

    private val spaghetti = ProductAvailability.Product(
        "Spaghetti", 3, 20.0)

    private val steak = ProductAvailability.Product("Steak", 8, 30.0 )
    @Test
    fun `test for discount for less than five`(){
        spaghetti.applyDiscount(20)
        assertEquals(16.00, spaghetti.price, 0.0)
    }

    @Test
    fun `test for discount for no discount`(){
        steak.applyDiscount(20)
        assertEquals(30.00, steak.price, 0.0)
    }

}