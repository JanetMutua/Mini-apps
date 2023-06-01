package com.example.numerouno

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextEditCapabilities(){
    val fontFamily = FontFamily(
        Font(R.font.rubikpuddles_regular, FontWeight.Bold)
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF333e48))
    ){
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 60.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                ){
                    append("The goal")
                }
                append("is to be so damn good at my craft!!")
            },
            color = Color.White,
            fontFamily = fontFamily,
            fontSize = 40.sp,
            textAlign = TextAlign.Center

            )
    }

}