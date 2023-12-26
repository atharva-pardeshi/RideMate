package com.example.ridemate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ridemate.ui.presentation.onbording.LoginScreen
import com.example.ridemate.ui.presentation.onbording.OtpScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "Login Screen",
        /*enterTransition = {
               slideIntoContainer(
                   towards = AnimatedContentTransitionScope.SlideDirection.Start,
                   animationSpec = tween(durationMillis = 500)
               )
           }, exitTransition = {
               fadeOut(
       //            towards = AnimatedContentTransitionScope.SlideDirection.End,
                   animationSpec = tween(durationMillis = 500)
               )
           }, popEnterTransition = {
               fadeIn(
       //            towards = AnimatedContentTransitionScope.SlideDirection.Start,
                   animationSpec = tween(durationMillis = 500)
               )
           }, popExitTransition = {
               slideOutOfContainer(
                   towards = AnimatedContentTransitionScope.SlideDirection.End,
                   animationSpec = tween(durationMillis = 500)
               )
           }*/
    ) {
        composable("Login Screen") {
            LoginScreen(navController = navController)
        }

        composable("OTP Screen") {
            OtpScreen(navController = navController)
        }
    }
}