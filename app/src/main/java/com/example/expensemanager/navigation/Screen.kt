package com.example.expensemanager.navigation

sealed class Screen(val route :String){
    object SplashScreen: Screen("splash_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object HomeScreen: Screen("home_screen")
    object AnalysisScreen: Screen("analysis_screen")
}
