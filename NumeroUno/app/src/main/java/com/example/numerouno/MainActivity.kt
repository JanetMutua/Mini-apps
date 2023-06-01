package com.example.numerouno
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.numerouno.lessons.ListView
import com.example.numerouno.ui.theme.ChangingColoredBox
import com.example.numerouno.ui.theme.PlayWithColoredBox


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //=========================start section========================================

            //-----------Creating Image cards---------
            //ApplyImageCardFunction()

            //------------Editing text-------------
            //TextEditCapabilities()

            //--------------Applying states changes with a colored box-------------------
            //PlayWithColoredBox()

            //----------------Creating buttons, snackbars and edit text in Compose-----------------
            ListView()

            //==============================end of section=================================



        }
    }
}

