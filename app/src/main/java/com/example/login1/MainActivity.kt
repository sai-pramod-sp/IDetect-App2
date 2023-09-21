package com.example.login1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login1.Screens.HomeScreen
import com.example.login1.Screens.LoginScreen
import com.example.login1.Screens.RegisterScreen
import com.example.login1.Screens.Screen
import com.example.login1.Screens.TermsandCondition
import com.example.login1.ui.theme.Login1Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.RegisterScreen.route
            ){
                composable(route = Screen.RegisterScreen.route){
                    RegisterScreen(navController = navController)
                }
                composable(route = Screen.TermsandConditions.route){
                    TermsandCondition(navController = navController)
                }
                composable(route = Screen.LoginScreen.route){
                    LoginScreen(navController = navController)
                }
                composable(route = Screen.HomeScreen.route){
                    HomeScreen(navController = navController)
                }

            }
        }
    }

}