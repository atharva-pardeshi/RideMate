package com.example.ridemate.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ridemate.ui.presentation.onbording.LoginScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login Screen", enterTransition = {
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
    }) {
        composable("Login Screen") {
            LoginScreen(navController = navController)
        }

        composable("Forgot Password Screen") {
//            ForgotPassword(navController = navController)
        }

        composable("SignUp Screen") {
//            SignUp(navController = navController)
        }

        composable("Home Screen") {
//            Home(navController = navController)
        }

        composable("Onboarding Hello Screen") {
//            OnboardingHello(navController = navController)
        }

        composable("Onboarding TellUs Body Screen") {
//            OnboardingTellUsBody(navController = navController)
        }

        composable("Onboarding TellUs Health Screen") {
//            OnboardingTellUsHealth(navController = navController)
        }

        composable("Select Provider Screen") {
//            SelectProvider(navController = navController)
        }

        composable("Thank You Screen") {
//            ThankYou(navController = navController)
        }

        composable("Verify OTP Screen") {
//            VerifyOTP(navController = navController)
        }

        composable("New Password Screen") {
//            SetNewPassword(navController = navController)
        }
    }
}