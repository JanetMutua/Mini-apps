package com.example.littlelemon


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember{
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    LoginScreen(navController, username, password,
        onNameChange = {username = it},
        onPasswordChange = {password = it}
    )

}

@Composable
fun LoginScreen(
    navController: NavHostController,
    username:String,
    password:String,
    onNameChange: (String) -> Unit,
    onPasswordChange:(String) -> Unit,
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
            contentDescription = stringResource(id = R.string.logo_content_description),
            modifier.padding(10.dp)
        )

        OutlinedTextField(
            value = "$username",
            onValueChange = onNameChange,
            label = {Text(text = "Username") },
            modifier = Modifier.padding(10.dp)
        )


        OutlinedTextField(
            value = "$password",
            onValueChange = onPasswordChange,
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(10.dp)
        )

        Button(
            onClick = {
                  navController.navigate(Home.route)
//                if(username == "Darian" && password == "littlelemon"){
//                    Toast.makeText(context, "Welcome to Little Lemon", Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(context, "Invalid Credentials" + "Please try again", Toast.LENGTH_SHORT).show()
//                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            ),
            modifier = Modifier.padding(10.dp),

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

