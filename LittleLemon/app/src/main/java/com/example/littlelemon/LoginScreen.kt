package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(
                id = R.drawable.little_lemon_logo),
            contentDescription = stringResource(id = R.string.logo_content_description) )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.username_input)) }
        )

        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.password_input)) }
        )

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            ),

            //this parameter helps add padding to the inner content
            contentPadding = PaddingValues(
                start = 18.dp,
                top = 16.dp,
                end = 18.dp,
                bottom = 16.dp
            )

        ) {
            //content slot for Inner content (generic lambda)
            //uses a RowScope to layout content in a row
            Text(
                text = stringResource(id = R.string.login),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){
    LoginScreen()
}