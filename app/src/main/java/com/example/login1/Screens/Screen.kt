package com.example.login1.Screens

sealed class Screen(val route: String){
    object RegisterScreen: Screen("SignUp")
    object TermsandConditions: Screen("termsAndConditions")
    object LoginScreen: Screen("Login")
    object HomeScreen: Screen("homescreen")
}
