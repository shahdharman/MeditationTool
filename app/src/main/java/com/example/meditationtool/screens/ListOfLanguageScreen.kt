package com.example.meditationtool.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditationtool.MainActivity
import com.example.meditationtool.R
import com.example.meditationtool.data.HelpMeditation
import com.example.meditationtool.navigation.MeditationEnum

@Composable
fun ListOfLanguageScreen(navController: NavHostController) {
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize(),
        //,
    ){
        Column(modifier = Modifier.background(color = MaterialTheme.colors.surface)){
            TopAppBar(title = {
                Text(text = "List of Languages ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Green
                )
            },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back button",
                        tint = Color.Green,
                        modifier = Modifier.clickable {
                            context.startActivity(Intent(context, MainActivity::class.java))
                        })
                },elevation = 20.dp,
                actions = {
                    Image(painter = painterResource(id = R.drawable.help)
                        , contentDescription = "HelpIcon",contentScale = ContentScale.Fit,
                        modifier = Modifier.size(30.dp).clickable{
                            navController.navigate(MeditationEnum.HelpScreen.name)
                        })
                }
            )
            Spacer(Modifier.height(5.dp))
            Text(modifier = Modifier.padding(start = 20.dp), text = "Select language based on your expertise"
                ,color = Color.Blue, fontSize = 20.sp)
            Spacer(Modifier.height(5.dp))

            LazyColumn {
                itemsIndexed(
                    listOf(
                        "English",
                        "Hindi",
                        "Bengali",
                        "Gujarati",
                        "Tamil ",
                        "Telugu",
                        "Kanada",
                    )
                ) { index, string ->
                    Card(modifier = Modifier.fillMaxWidth().padding(20.dp).clickable {
                        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
                    }
                        , elevation = 15.dp,
                        backgroundColor = Color.Black){
                        Text(
                            text = string, modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 25.sp, fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                }
            }
        }

    }

}
@Preview
@Composable
fun ListOfLanguageScreenPreview(){
    ListOfLanguageScreen(navController = rememberNavController())
}