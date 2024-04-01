package com.example.login1.Utils.ViewModels

import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.VideoCameraBack
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.ViewModel
import com.example.login1.Utils.NavigationItems
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


class ImageDetectViewModle: ViewModel() {

    val navigationItemsList = listOf<NavigationItems>(
        NavigationItems(
            title = "Home",
            image = Icons.Default.Home,
            description = "Home Screen",
            itemId = "homeScreen"
        ),
        NavigationItems(
            title = "Cart",
            image = Icons.Default.ShoppingCart,
            description = "Cart",
            itemId = "Cart"
        ),
        NavigationItems(
            title = "Favourite",
            image = Icons.Default.Favorite,
            description = "Favorite Screen",
            itemId = "favoriteScreen"
        ),
        NavigationItems(
            title = "ImageDetect",
            image = Icons.Default.ImageSearch,
            description = "Image Detect",
            itemId = "ImageScreen"
        ),
        NavigationItems(
            title = "Video Detect",
            image = Icons.Default.VideoCameraBack,
            description = "Video Detect",
            itemId = "VideoScreen"
        ),
        NavigationItems(
            title = "LiveDetect",
            image = Icons.Default.LiveTv,
            description = "Live Detect",
            itemId = "LiveScreen"
        ),
        NavigationItems(
            title = "Settings",
            image = Icons.Default.Settings,
            description = "Settings Screen",
            itemId = "settingsScreen"
        ),
        NavigationItems(
            title = "Logout",
            image = Icons.Default.Logout,
            description = "Logout Screen",
            itemId = "LogoutScreen"
        )
    )

}