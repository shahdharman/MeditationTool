package com.example.meditationtool.navigation

import androidx.compose.runtime.Composable


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditationtool.screens.*

@Composable
//handles navigation related to our whole application.
fun MeditationNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MeditationEnum.HomeScreen.name){
        composable(MeditationEnum.LevelsScreen.name){
            ListOfLevelsScreen(navController = navController)
        }
        composable(MeditationEnum.LanguagesScreen.name){
            ListOfLanguageScreen(navController = navController)
        }
        composable(MeditationEnum.InstructorScreen.name){
            ListOfInstructorScreen(navController = navController)
        }
        composable(MeditationEnum.HomeScreen.name){
            MeditationHomeScreen(navController = navController)
        }
        composable(MeditationEnum.HelpScreen.name){
            HelpMeditationScreen(navController = navController)
        }
        composable(MeditationEnum.MusicPlayerScreen.name){
            MusicPlayerScreen(navController = navController)
        }
    }
}