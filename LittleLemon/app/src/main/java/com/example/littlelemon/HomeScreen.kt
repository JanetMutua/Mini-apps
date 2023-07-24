package com.example.littlelemon

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.DrawerPanel

//==================================Caller function====================================

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold (
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope = scope) },
        topBar = {
            com.example.littlelemon.ui.theme.TopAppBar(scaffoldState = scaffoldState, scope = scope)
        }
    ){
        LazyColumn{
            this.item {
                UpperPanel()
                LowerPanel()
                OrderItemImplementation()
            }

        }
    }
}


//==================================Upper Panel====================================
@Composable
fun UpperPanel(){
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))

    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 40.sp,
            color = Color(0xFFFAD02C),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 26.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start
        ){

            Text(
                text = stringResource(id = R.string.about_little_lemon),
                Modifier.width(200.dp),
                fontSize = 16.sp,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.upper_panel_image),
                contentDescription = stringResource(
                    id = R.string.logo_content_description),
                Modifier
                    .height(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(context, "Order successful", Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF4CE14)
            )
        ) {
            Text(
                text = stringResource(id = R.string.order),
            )
        }
    }

}

//==================================Lower Panel====================================
@Composable
fun LowerPanel(){

    Column {
        WeeklySpecial()
        MenuDish()
    }

}

@Composable
fun WeeklySpecial(){

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Weekly Special",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

    }

}

@Composable
fun MenuDish(){

    Card {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Column {
                Text(
                    text = "Greek Salad",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "12.99",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(painter = painterResource(id = R.drawable.greeksalad) , contentDescription = "Greek salad Image")
        }
    }

}

//===========================================Order Implemetation section==========================

@Composable
fun OrderItemImplementation(){

    //state hoisting
    var itemCount by rememberSaveable{
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