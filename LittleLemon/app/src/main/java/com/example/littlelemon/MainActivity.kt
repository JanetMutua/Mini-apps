package com.example.littlelemon

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.DrawerPanel
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.TopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    HomeScreen()
                    //loadLoginScreen()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun HomeScreen(){
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        Scaffold (
            scaffoldState = scaffoldState,
            drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope = scope)},
            topBar = {
                TopAppBar(scaffoldState = scaffoldState, scope = scope)
            }
        ){
            LazyColumn{
                this.item {
                    MainScreen()
                    LowerPanel()
                    OrderItemImplementation()
                }

            }
        }
    }

    @Composable
    fun OrderItemImplementation(){

        //state hoisting
        var itemCount by rememberSaveable() {
            mutableStateOf(0)
        }

        OrderItem(count = itemCount, {itemCount++}, {itemCount--})
    }

    @Composable
    private fun OrderItem(count:Int, countIncrement: () -> Unit, countDecrement:() -> Unit){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Card(elevation = 32.dp) {

                Column(modifier = Modifier.padding(20.dp)) {

                    Text(
                        text = "Chicken tacos",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        IconButton(onClick = countDecrement ) {

                            Icon(
                                imageVector = Icons.Default.Delete ,
                                contentDescription = "Remove"
                            )
                        }

                        Text(
                            text = "$count",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )

                        IconButton(onClick = countIncrement) {
                            Icon(
                                contentDescription = "Add",
                                imageVector = Icons.Default.Add
                            )

                        }

                    }

                    Button(
                        onClick = { /*TODO*/ },
                        Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                    ) {
                        Text(text = "Order")

                    }
                }

            }

        }
    }

    @Preview
    @Composable
    fun PreviewOrderItem(){
        OrderItemImplementation()
    }
}

