package com.example.messager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.messager.ui.theme.MessagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayCardWithMessage(message = "Happy Birthday Baby!", from = "~Janet")
    
                }
            }
        }
    }
}

@Composable
//best practice to add modifier to the composable function as a parameter
fun BirthdayCardWithMessage(message:String, from:String, modifier: Modifier=Modifier){

//    Add the modifier to the Column which is the first child that emits the UI
    Column(
        modifier = modifier
    ){
        Text(text = message, fontSize = 36.sp)
        Text(text = from, fontSize=20.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardWithMessagePreview() {
    MessagerTheme {
        BirthdayCardWithMessage(message = "Happy Birthday Baby!", from = "~Janet")

    }
}