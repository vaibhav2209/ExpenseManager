package com.example.expensemanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensemanager.auth.presentation.login.LoginScreen
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screen.LoginScreen.route
    ){

        composable(route = Screen.SplashScreen.route){

        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }

        composable(route = Screen.RegisterScreen.route){

        }


    }
}