package com.example.meditationtool.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditationtool.R
import com.example.meditationtool.components.TimerImplementation
import com.example.meditationtool.navigation.MeditationEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  MeditationHomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    val sheetState = androidx.compose.material3.rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var isSheetOpen by remember{
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.DarkGray
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            TopAppBar(title = {
                Text(
                    text = "Meditation tool ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Green
                )
            },
                elevation = 20.dp,
                actions = {
                    Image(painter = painterResource(id = R.drawable.help),
                        contentDescription = "HelpIcon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate(MeditationEnum.HelpScreen.name)
                            })
                }
            )

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(20.dp), elevation = 20.dp,

                //border = BorderStroke(width = 1.dp,Color.Green),
                backgroundColor = Color.DarkGray
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier
                            .width(IntrinsicSize.Max)

                        //.border(width = 1.dp, color = Color.DarkGray)
                        ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        TimerImplementation(
                            totalTime = 30 * 3600 * 1000, handleColor = Color.Black,
                            inactiveBarColor = Color.DarkGray,
                            activeBarColor = MaterialTheme.colors.primary
                        ){
                           it ->
                            isSheetOpen = if(it as Boolean) true
                            else false
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Duration",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.Cursive
                            ),

                            color = Color.White

                        )
                        //Spacer(modifier = Modifier.height(5.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(1.dp), thickness = 1.dp, color = Color.Red
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "30 minutes",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Cursive
                            ),
                            color = Color.White

                        )
                    }

                    Row(
                        modifier = Modifier
                            //.border(1.dp, color = Color.Black)
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                        //verticalArrangement = Arrangement.Center,
                        //horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Column(
                            modifier = Modifier
                                .width(IntrinsicSize.Max)
                                .padding(10.dp)
                            //.border(1.dp, color = Color.Black)
                            ,
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "40 min",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Cursive,
                                ),

                                color = Color.White

                            )
                            //Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                color = Color.Red, modifier = Modifier
                                    .fillMaxWidth()
                                    .width(1.dp)
                            )
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "Recommended",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.Cursive

                                ),
                                color = Color.White

                            )
                        }
                        //Spacer(modifier = Modifier.height(5.dp))
                        Divider(
                            modifier = Modifier.width(1.dp),
                            thickness = 1.dp,
                            color = Color.Blue
                        )
                        Column(
                            modifier = Modifier
                                .width(IntrinsicSize.Max)
                                .padding(10.dp)
                            //.border(1.dp, color = Color.Black)
                            ,
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "35 min",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Cursive

                                ),

                                color = Color.White

                            )
                            //Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                color = Color.Red, modifier = Modifier
                                    .fillMaxWidth()
                                    .width(1.dp)
                            )

                            Text(
                                modifier = Modifier
                                    .width(IntrinsicSize.Max)
                                    .padding(5.dp),
                                text = "Goal",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.Cursive

                                ),
                                color = Color.White

                            )
                        }
                        //Spacer(modifier = Modifier.height(5.dp))
                        Divider(
                            modifier = Modifier.width(1.dp),
                            thickness = 1.dp,
                            color = Color.Blue
                        )
                        Column(
                            modifier = Modifier
                                .width(IntrinsicSize.Max)
                                .padding(10.dp)
                            //.border(1.dp, color = Color.Black)
                            ,
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "20 min",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Cursive

                                ),

                                color = Color.White

                            )
                            Divider(
                                color = Color.Red, modifier = Modifier
                                    .fillMaxWidth()
                                    .width(1.dp)
                            )
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "Achieved",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.Cursive

                                ),
                                color = Color.White

                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .alpha(if (isSheetOpen) 0f else 1f)
                    .padding(10.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(20.dp), elevation = 20.dp,

                //border = BorderStroke(width = 1.dp,Color.Green),
                backgroundColor = Color.DarkGray
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "18°", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "⚲ Dwarka,Delhi",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rain),
                            contentDescription = "Rainny",
                            contentScale = ContentScale.Crop,
                            alpha = 1f,

                            )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Friday,24 June", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            //show below card when bottom sheets isn't open
            Card(
                modifier = Modifier
                    .alpha(if (isSheetOpen) 1f else 0f)
                    .padding(10.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(20.dp), elevation = 20.dp,

                //border = BorderStroke(width = 1.dp,Color.Green),
                backgroundColor = Color.DarkGray
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "Sunny",
                            contentScale = ContentScale.Crop,
                            alpha = 1f,

                            )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "25°", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )


                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Total Vitamin D", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "300 IU", style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
            BottomSheet(sheetState = sheetState, onDismiss = { isSheetOpen = false }
                ,navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    onDismiss:() -> Unit,
    navController:NavHostController
){
    LaunchedEffect(key1 = Unit) {
        sheetState.expand()
    }
    if (sheetState.isVisible){
        ModalBottomSheet(

            sheetState = sheetState,
            onDismissRequest = {
                onDismiss()
            },
            dragHandle = { BottomSheetDefaults.DragHandle() }
        )
        {

            Column(modifier = Modifier.padding(6.dp)){
                Row(){
                    Card(modifier = Modifier
                        .clickable {
                            navController.navigate(MeditationEnum.MusicPlayerScreen.name)
                        }
                        .padding(10.dp)
                        , shape = RoundedCornerShape(20.dp), elevation = 20.dp,
                    ){
                        Row(){
                            Image(painter = painterResource(R.drawable.music), contentDescription = "music",
                                contentScale = ContentScale.Fit,modifier = Modifier.size(20.dp))
                            Spacer(Modifier.height(5.dp))
                            Column(){
                                Text(text = "Music",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(text = "Healing Energy",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Card(modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(MeditationEnum.InstructorScreen.name)
                        }
                        , shape = RoundedCornerShape(20.dp), elevation = 20.dp,
                    ){
                        Row(){
                            Image(painter = painterResource(R.drawable.instructor), contentDescription = "music",
                                contentScale = ContentScale.Fit,modifier = Modifier.size(20.dp))
                            Column(){
                                Text(text = "Instructor",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Text(text = "Ronald Richard",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                    }
                }
                Row(){
                    Card(modifier = Modifier
                        .clickable {
                            navController.navigate(MeditationEnum.LevelsScreen.name)
                        }
                        .padding(10.dp)
                        , shape = RoundedCornerShape(20.dp), elevation = 20.dp,
                    ){
                        Row(){
                            Image(painter = painterResource(R.drawable.level), contentDescription = "music",
                                contentScale = ContentScale.Fit,modifier = Modifier.size(20.dp))
                            Column(){
                                Text(text = "Level",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(text = "Beginner",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                    }
                    Card(modifier = Modifier
                        .clickable {
                            navController.navigate(MeditationEnum.LanguagesScreen.name)
                        }
                        .padding(10.dp)
                        , shape = RoundedCornerShape(20.dp), elevation = 20.dp,
                    ){
                        Row(){
                            Image(painter = painterResource(R.drawable.language), contentDescription = "music",
                                contentScale = ContentScale.Fit,modifier = Modifier.size(20.dp))
                            Column(){
                                Text(text = "Language",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                                Text(text = "Hindi",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}
@Preview
@Composable
fun MeditationHomeScreenPreview(){
    MeditationHomeScreen(navController = rememberNavController())
}