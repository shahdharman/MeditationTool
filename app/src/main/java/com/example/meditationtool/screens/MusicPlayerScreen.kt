package com.example.meditationtool.screens

import android.content.Context
import android.media.MediaPlayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditationtool.R
@Composable
fun MusicPlayerScreen(navController: NavHostController) {
    val context = LocalContext.current
    Surface(
        modifier =Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        PlayAudio(context)
    }
}


@Composable
fun PlayAudio(context: Context) {
    val mp: MediaPlayer = MediaPlayer.create(context, R.raw.audio)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.music), contentDescription = "",
            modifier = Modifier
                .padding(32.dp)
                .height(160.dp)
                .width(160.dp)
                .background(Color.Black)
        )

        Row(

        ) {
            IconButton(onClick = { mp.start() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24),
                    contentDescription = ""
                )
            }

            IconButton(onClick = { mp.pause() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_pause_circle_outline_24),
                    contentDescription = ""
                )
            }


        }
    }
}
@Preview
@Composable
fun MusicPlayerScreenPreview() {
    MusicPlayerScreen(navController = rememberNavController())
}
