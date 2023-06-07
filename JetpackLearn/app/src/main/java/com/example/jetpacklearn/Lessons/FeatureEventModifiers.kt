package com.example.jetpacklearn.Lessons

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventModifiersUseCase(){

    val counterIncrementor = remember{ mutableStateOf(0)}

    val normalClicks = remember {
        mutableStateOf(0)
    }
    val longClicks = remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        //clickable modifier
        Text(
            text = "Clicks: "+ counterIncrementor.value.toString(),
            modifier = Modifier.clickable{counterIncrementor.value += 1},
            fontSize = 32.sp
        )

        //combinedClickable modifier
        Text(
            text =
            "Normal clicks:" + normalClicks.value.toString() +
                    "Long clicks:" + "  " + longClicks.value.toString(),
            modifier = Modifier.combinedClickable(
                onClick = {normalClicks.value += 1}, onLongClick = {longClicks.value += 1}
            )

        )

        //draggable modifier

        Box(modifier = Modifier
            .draggable(
                state = rememberDraggableState(onDelta = {0.0}),
                orientation = Orientation.Vertical,
                onDragStarted = { Log.d("Box", "Starting Drag") },
                onDragStopped = { Log.d("Box", "Finishing Drag") }
            )
        )

    }



}