package com.example.meditationtool.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
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
import com.example.meditationtool.R
import com.example.meditationtool.MainActivity
import com.example.meditationtool.data.HelpMeditation

@Composable
fun HelpMeditationScreen(navController: NavHostController) {
    val context = LocalContext.current
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray
    ){
        Column(){
            TopAppBar(title = {
                Text(text = "Help-Meditation",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
                )
            }, contentColor = Color.Gray,
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back button",
                        tint = Color.Black,
                        modifier = Modifier.clickable {
                            context.startActivity(Intent(context, MainActivity::class.java))
                        })
                },elevation = 20.dp, backgroundColor = Color.DarkGray
            )
            LazyColumn {
                itemsIndexed(
                    listOf(
                        HelpMeditation(
                            1,
                            "How Meditation can help improve health and well-being?",
                            "Meditation profoundly enhances health and well-being through stress reduction, fostering emotional balance, and improving concentration. By activating the relaxation response, it mitigates stress hormones, promoting a sense of calm. Regular practice correlates with heightened positive emotions and greater self-awareness, offering emotional resilience. Improved focus and attention result from cultivating mindfulness during meditation, enhancing cognitive abilities. Sleep quality often improves as racing thoughts diminish, and the practice has been associated with lower blood pressure, benefiting cardiovascular health. Additionally, meditation's impact on immune function, pain management, and self-awareness contribute to a holistic approach to overall health and a more profound sense of well-being"
                            ,
                            R.drawable.download

                        ),
                        HelpMeditation(
                            2,
                            "What meditation works for you?",
                            "Meditation profoundly enhances health and well-being through stress reduction, fostering emotional balance, and improving concentration. By activating the relaxation response, it mitigates stress hormones, promoting a sense of calm. Regular practice correlates with heightened positive emotions and greater self-awareness, offering emotional resilience. Improved focus and attention result from cultivating mindfulness during meditation, enhancing cognitive abilities. Sleep quality often improves as racing thoughts diminish, and the practice has been associated with lower blood pressure, benefiting cardiovascular health. Additionally, meditation's impact on immune function, pain management, and self-awareness contribute to a holistic approach to overall health and a more profound sense of well-being",

                            R.drawable.flower
                        )
                        )
                ) { index, helpmeditation ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clickable {
                            Toast
                                .makeText(context, helpmeditation.id, Toast.LENGTH_LONG)
                                .show()
                        }
                        , elevation = 15.dp,
                        backgroundColor = Color.White){
                        Column(){
                            Text(
                                text = helpmeditation.question, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                fontSize = 25.sp, fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                            Image(
                                modifier = Modifier.fillMaxWidth().heightIn(200.dp).padding(8.dp),
                                painter = painterResource(id = helpmeditation.imageRes),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = helpmeditation.answer, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                fontSize = 25.sp, fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }

                    }

                }
            }
        }

    }

}
@Preview
@Composable
fun HelpMeditationScreenPreview(){
    HelpMeditationScreen(navController = rememberNavController())
}