package com.example.login1.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.login1.Components.AppTopBar
import com.example.login1.Components.NavigationDrawerBody
import com.example.login1.Components.NavigationDrawerHeader
import com.example.login1.R
import com.example.login1.Utils.HomeViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                NavigationDrawerHeader()
                NavigationDrawerBody(
                    navigationItems = viewModel.navigationItemsList,
                    navigationItemClicked = {
                        if(it.title == "Favourite") {
                            navController.navigate(DrawerScreens.Favourites.route)
                        }
                        else if (it.title == "Home") navController.navigate(Screen.HomeScreen.route)
                        else if (it.title == "Cart") navController.navigate(DrawerScreens.Cart.route)
                        else if (it.title == "ImageDetect") navController.navigate(DrawerScreens.ImageDetect.route)
                        else if (it.title == "Video Detect") navController.navigate(DrawerScreens.Video.route)
                        else if (it.title == "LiveDetect") navController.navigate(DrawerScreens.Live.route)
                        else if (it.title == "Settings") navController.navigate(DrawerScreens.Settings.route)
                        else if (it.title == "Logout") navController.navigate(DrawerScreens.Logout.route)
                    }
                )
            }
        }
    ){

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            topBar = {
                AppTopBar(toolbarTitle = stringResource(id = R.string.IDetect),
                    logoutButtonClicked = {

                    },
                    navigationButtonClicked ={
                        coroutineScope.launch {
                            drawerState.apply {
                                if(isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ){

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Fav Page content comes here.")
            }
        }

    }


}