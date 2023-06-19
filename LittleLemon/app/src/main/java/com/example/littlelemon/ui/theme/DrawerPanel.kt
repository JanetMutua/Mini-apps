package com.example.littlelemon.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerPanel(scaffoldState: ScaffoldState, scope:CoroutineScope){
    
    List(10){
        Text(
            text = "Item #$it",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
    
    IconButton(onClick = {scope?.launch { scaffoldState?.drawerState?.close() }}) {
        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "up button")
    }
}