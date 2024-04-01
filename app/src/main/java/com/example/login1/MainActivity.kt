package com.example.login1

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login1.Screens.CartScreen
import com.example.login1.Screens.DrawerScreens
import com.example.login1.Screens.FavouriteScreen
import com.example.login1.Screens.HomeScreen
import com.example.login1.Screens.ImageScreen
import com.example.login1.Screens.LiveScreen
import com.example.login1.Screens.LoginScreen
import com.example.login1.Screens.LogoutScreen
import com.example.login1.Screens.RegisterScreen
import com.example.login1.Screens.Screen
import com.example.login1.Screens.SettingsScreen
import com.example.login1.Screens.TermsandCondition
import com.example.login1.Screens.videoScreen
import com.example.login1.ui.theme.Login1Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    val permissionRequest: MutableList<String> = ArrayList()

    private var isreadmediaaudio = false
    private var isreadmediavideo = false
    private var isreadmediaimages = false
    private var iscamera = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        grantruntimepermission()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = DrawerScreens.ImageDetect.route
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
                composable(route = DrawerScreens.Settings.route){
                    SettingsScreen(navController = navController)

                }
                composable(route = DrawerScreens.Cart.route){
                    CartScreen(navController = navController)
                }
                composable(route = DrawerScreens.Favourites.route){
                    FavouriteScreen(navController = navController)

                }
                composable(route = DrawerScreens.ImageDetect.route){
                    ImageScreen(navController = navController)
                }
                composable(route = DrawerScreens.Video.route){
                    videoScreen(navController = navController)
                }
                composable(route = DrawerScreens.Live.route){
                    LiveScreen(navController = navController)
                }
                composable(route = DrawerScreens.Logout.route){
                    LogoutScreen(navController = navController)
                }

            }
        }
    }

    fun grantruntimepermission(){

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permission ->

            isreadmediaaudio = permission[Manifest.permission.READ_MEDIA_AUDIO] ?: isreadmediaaudio
            isreadmediavideo = permission[Manifest.permission.READ_MEDIA_VIDEO] ?: isreadmediavideo
            isreadmediaimages = permission[Manifest.permission.READ_MEDIA_IMAGES] ?: isreadmediaimages
            iscamera = permission[Manifest.permission.CAMERA] ?: iscamera

        }

        isreadmediaaudio = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO) == PackageManager.PERMISSION_GRANTED
        isreadmediavideo = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VIDEO) == PackageManager.PERMISSION_GRANTED
        isreadmediaimages = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED
        iscamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

        if(!iscamera){
            permissionRequest.add(Manifest.permission.CAMERA)
        }
        if(!isreadmediaaudio){
            permissionRequest.add(Manifest.permission.READ_MEDIA_AUDIO)
        }
        if(!isreadmediavideo){
            permissionRequest.add(Manifest.permission.READ_MEDIA_VIDEO)
        }
        if(!isreadmediaimages){
            permissionRequest.add(Manifest.permission.READ_MEDIA_IMAGES)
        }

        if(permissionRequest.isNotEmpty()){
            permissionLauncher.launch(permissionRequest.toTypedArray())
        }


    }

}