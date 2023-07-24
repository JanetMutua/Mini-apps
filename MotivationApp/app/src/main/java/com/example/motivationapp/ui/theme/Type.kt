package com.example.motivationapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.motivationapp.R

// Set of Material typography styles to start with
val kanit = FontFamily(
    listOf(
        Font(R.font.kanit_light, FontWeight.Normal),
        Font(R.font.kanit_regular, FontWeight.Medium),
        Font(R.font.kanit_medium, FontWeight.SemiBold),
        Font(R.font.kanit_semibold, FontWeight.Bold),
        Font(R.font.kanit_bold, FontWeight.Black)
    )
)

val Typography = Typography(
    bodySmall = TextStyle(
        color = TextWhite,
        fontFamily = kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    bodyMedium = TextStyle(
        color = TextWhite,
        fontFamily = kanit,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        color = AquaBlue,
        fontFamily = kanit,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    headlineLarge = TextStyle(
        color = TextWhite,
        fontFamily = kanit,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    headlineMedium = TextStyle(
        color = TextWhite,
        fontFamily = kanit,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )
)

