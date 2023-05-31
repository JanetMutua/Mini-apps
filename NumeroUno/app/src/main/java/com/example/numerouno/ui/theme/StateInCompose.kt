package com.example.numerouno.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


@Composable
fun ChangingColoredBox(

    modifier: Modifier = Modifier,
    //defining a callback
    updateMyColor: (Color) -> Unit
){

    Box(
        modifier = modifier
            .background(Color.Gray)
            .clickable {
                updateMyColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )

            }
    )
}

@Composable
fun PlayWithColoredBox(modifier: Modifier = Modifier){
    
    Column(modifier.fillMaxSize()) {
        //defining color state
        val color = remember{mutableStateOf(Color.Blue)}

        ChangingColoredBox(
            modifier
                .fillMaxSize()
                .weight(1f)
        ){
            color.value = it
        }

        Box(
            modifier
                .background(color.value)
                .fillMaxSize()
                .weight(1f)
        )
    }



}