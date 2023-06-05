package com.example.numerouno.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ThisConstraintLayout(){

    val constraints = ConstraintSet{
        val blueBox = createRefFor("bluebox")
        val greenBox = createRefFor("greenbox")

        constrain(blueBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(greenBox){
            start.linkTo(greenBox.end)
            top.linkTo(parent.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("bluebox")
        )

        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
    }



}