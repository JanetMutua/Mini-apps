package com.example.numerouno
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //=========================start section========================================

            //-----------Creating Image cards---------
            //ApplyImageCardFunction()

            //------------Editing text-------------
            TextEditCapabilities()

            //==============================end of section=================================



        }
    }
}

