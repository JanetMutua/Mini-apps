package com.example.motivationapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivationapp.ui.theme.AquaBlue
import com.example.motivationapp.ui.theme.BeigeOne
import com.example.motivationapp.ui.theme.BeigeThree
import com.example.motivationapp.ui.theme.BeigeTwo
import com.example.motivationapp.ui.theme.BlueVioletOne
import com.example.motivationapp.ui.theme.BlueVioletThree
import com.example.motivationapp.ui.theme.BlueVioletTwo
import com.example.motivationapp.ui.theme.ButtonBlue
import com.example.motivationapp.ui.theme.DarkerButtonBlue
import com.example.motivationapp.ui.theme.DeepBlue
import com.example.motivationapp.ui.theme.LightGreenOne
import com.example.motivationapp.ui.theme.LightGreenThree
import com.example.motivationapp.ui.theme.LightGreenTwo
import com.example.motivationapp.ui.theme.LightRed
import com.example.motivationapp.ui.theme.OrangeYellowOne
import com.example.motivationapp.ui.theme.OrangeYellowThree
import com.example.motivationapp.ui.theme.OrangeYellowTwo
import com.example.motivationapp.ui.theme.TextWhite


//----------main home screen composable---------------
@Composable
fun HomeScreen(modifier:Modifier =
                   Modifier
                       .fillMaxSize()
                       .background(DeepBlue)
){

    Column {
        GreetingSection()
        LazyChips(
            listOf(
                "Better sleep", "Mantras", "Gratitude",
                "Breathing", "Mobility"
            ))
        DailyThought()
        FeatureSection(features = featureList)

        BottomMenu(items = listOf(
            BottomMenuBarContent("Home", R.drawable.ic_home),
            BottomMenuBarContent("Meditate", R.drawable.ic_diversity),
            BottomMenuBarContent("Sleep", R.drawable.ic_nights_stay),
            BottomMenuBarContent("Music", R.drawable.ic_music_note),
            BottomMenuBarContent("Profile", R.drawable.ic_person_outline)
        ))
    }




}

//---------------greeting section---------------
@Composable
fun GreetingSection(
    name:String = "Jamie"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Good Morning $name?",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "You can now level up your day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search Icon",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}

//------------------------lazy row section----------------------
@Composable
fun LazyChips(
    chips: List<String>
){
    var selectedChip by remember{
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChip == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(
                    text = chips[it],
                    color = TextWhite,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

//-----------------------------Daily thought section----------------

@Composable
fun DailyThought(
    color:Color = LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thoughts",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Meditation - 3-10 min",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_play_),
                contentDescription = "Play button",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

//-----------------------------------Featured section---------------------------------

@Composable
fun FeatureSection(features:List<Feature>){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding =
            PaddingValues(
                start = 7.5.dp, end = 7.5.dp, bottom =100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(features.size){
                FeatureItem(feature = features[it])
            }
        }
    }
}

//---------------------features list---------------------

val featureList:List<Feature> = listOf(
    Feature(
        title = "Sleep meditation",
        R.drawable.ic_videocam,
        BlueVioletOne,
        BlueVioletTwo,
        BlueVioletThree
    ),
    Feature(
        title = "Tips for anxiety",
        R.drawable.ic_headphones,
        LightGreenOne,
        LightGreenTwo,
        LightGreenThree
    ),
    Feature(
        title = "Calm your thoughts",
        R.drawable.ic_videocam,
        OrangeYellowOne,
        OrangeYellowTwo,
        OrangeYellowThree
    ),
    Feature(
        title = "Meditation 101",
        R.drawable.ic_headphones,
        BeigeOne,
        BeigeTwo,
        BeigeThree
    ),

    //second iteration
    Feature(
        title = "Grow your inner zen",
        R.drawable.ic_videocam,
        BlueVioletOne,
        BlueVioletTwo,
        BlueVioletThree
    ),
    Feature(
        title = "Master your emotions",
        R.drawable.ic_headphones,
        LightGreenOne,
        LightGreenTwo,
        LightGreenThree
    ),
    Feature(
        title = "100 days of meditation",
        R.drawable.ic_videocam,
        OrangeYellowOne,
        OrangeYellowTwo,
        OrangeYellowThree
    ),
    Feature(
        title = "Improve your sleep",
        R.drawable.ic_headphones,
        BeigeOne,
        BeigeTwo,
        BeigeThree
    ),


)

//------------------------item in the grid of Features section------

@Composable
fun FeatureItem(feature: Feature){
    BoxWithConstraints(
        modifier =
        Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {

        //Individual item dimensions
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPath1 = Offset(0f, height * 0.3f)
        val mediumColoredPath2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPath3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPath4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPath5 = Offset(width * 1.4f, -height.toFloat())

        //setting the medium colored path
        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPath1.x, mediumColoredPath1.y)
            graphicPathDrawer(mediumColoredPath1, mediumColoredPath2)
            graphicPathDrawer(mediumColoredPath2, mediumColoredPath3)
            graphicPathDrawer(mediumColoredPath3, mediumColoredPath4)
            graphicPathDrawer(mediumColoredPath4, mediumColoredPath5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        //Light colored path
        val lightColoredPath1 = Offset(0f, height * 0.35f)
        val lightColoredPath2 = Offset(width * 0.1f, height * 0.4f)
        val lightColoredPath3 = Offset(width * 0.3f, height * 0.35f)
        val lightColoredPath4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPath5 = Offset(width * 1.4f, -height.toFloat()/3f)

        //setting the light colored path
        val lightColoredPath = Path().apply {
            moveTo(lightColoredPath1.x, lightColoredPath1.y)
            graphicPathDrawer(lightColoredPath1, lightColoredPath2)
            graphicPathDrawer(lightColoredPath2, lightColoredPath3)
            graphicPathDrawer(lightColoredPath3, lightColoredPath4)
            graphicPathDrawer(lightColoredPath4, lightColoredPath5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier.fillMaxSize()
        ){
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )

            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
        }

        Box(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier =
                Modifier
                    .clickable {
                        //code here
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )

        }
    }
}

//---------------------------------Bottom navigation menu----------------------

@Composable
fun BottomMenu(
    items:List<BottomMenuBarContent>,
    activeHighlightColor:Color = ButtonBlue,
    activeTextColor:Color = Color.White,
    inactiveTextColor:Color = AquaBlue,
    initialSelectedItem: Int = 0,
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItem)
    }
    
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
        Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed {
                index,
                bottomMenuBarContent ->
            BottomMenuItem(
                item = bottomMenuBarContent,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                inactiveTextColor = inactiveTextColor,
                activeTextColor = activeTextColor
            ) {
                selectedItemIndex = index
            }

        }
    }
}

//individual bottom bar item
@Composable
fun BottomMenuItem(
    item:BottomMenuBarContent,
    isSelected:Boolean = false,
    activeHighlightColor:Color = ButtonBlue,
    activeTextColor:Color = Color.White,
    inactiveTextColor:Color = AquaBlue,
    onItemClick:() -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier =
            Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconId),
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                contentDescription = item.title,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color =
            if (isSelected)activeTextColor else inactiveTextColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

