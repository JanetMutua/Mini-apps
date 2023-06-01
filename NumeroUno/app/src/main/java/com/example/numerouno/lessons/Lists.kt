package com.example.numerouno.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListView(){
    //---------------------Scrollable column for a list with a definite size----------
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        for(i in 1..20){
//            Text(
//                text = "Item $i",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(vertical = 24.dp),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center
//            )
//        }
//    }

    //using LazyColumn

    LazyColumn{
        itemsIndexed(
            listOf("I", "am", "an", "Android", "developer")
        ){
            index, item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxSize().padding(24.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
        }

        //non-indexed list
//        items(156){
//            Text(
//                text = "Item $it",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(vertical = 24.dp),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center
//            )
//        }
    }
}
