package com.example.littlelemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@Composable
fun MainScreen(){
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}