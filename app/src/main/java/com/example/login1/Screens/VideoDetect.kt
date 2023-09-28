package com.example.login1.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun videoScreen(
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
                modifier = Modifier
                    .fillMaxSize()
                    .absolutePadding(50.dp, 100.dp, 50.dp, 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Video Detection", style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Image(painter = painterResource(id = R.drawable.baseline_video_camera_back_24),
                    contentDescription = "Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp))
                Spacer(modifier = Modifier.heightIn(10.dp))
                Row {
                    Button(
                        onClick = { /*TODO*/ },
                    ){
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .heightIn(20.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "Gallery")
                        }

                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Button(
                        onClick = { /*TODO*/ },
                    ){
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .heightIn(20.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "Camera")
                        }

                    }
                }
            }
        }

    }


}