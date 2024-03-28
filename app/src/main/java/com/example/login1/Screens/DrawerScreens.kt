package com.example.login1.Screens

sealed class DrawerScreens(val route: String){
    object Settings: DrawerScreens("Home")
    object Favourites: DrawerScreens("Favouritey")
    object Cart:DrawerScreens("Cart")
    object ImageDetect: DrawerScreens("Image")
    object Video:DrawerScreens("Video")
    object Live:DrawerScreens("Live")
    object Logout:DrawerScreens("Logout")
}
