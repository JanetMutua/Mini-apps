package com.example.littlelemon.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(scaffoldState: ScaffoldState? = null, scope:CoroutineScope? = null){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = {
            scope?.launch { scaffoldState?.drawerState?.open() }
        }) {
            Image(
                painter = painterResource(id = R.drawable.baseline_menu),
                contentDescription = "Drawer menu icon",
                modifier = Modifier.size(20.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "Little lemon logo",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(horizontal = 20.dp)
        )

        IconButton(onClick = {
        }) {
            Image(
                painter = painterResource(id = R.drawable.baseline_shopping_bag),
                contentDescription = "Shopping bag icon",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun topAppBarPreview(){
    TopAppBar()
}