package com.example.littlelemonrestaurant

import junit.framework.TestCase.assertEquals
import org.junit.Test


internal class PriceCalculatorTest{
    private val classUnderTest = PriceCalculator()

    @Test
    fun `validate calculation`(){

        val result = classUnderTest.calculateMealPrice(
            3.00, 5.00, 0.20
        )
        assertEquals(9.60, result, 0.001)
    }
}