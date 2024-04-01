package com.example.login1.Screens

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.login1.Components.DetectFragment
import com.example.login1.Components.NavigationDrawerBody
import com.example.login1.Components.NavigationDrawerHeader
import com.example.login1.Components.DetectFragment
import com.example.login1.R
import com.example.login1.Utils.HomeViewModel

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
                    navController
                )
            }
        }
    ){

        DetectFragment(title = stringResource(id = R.string.VideoDetect),
            state = drawerState,
            drawable = R.drawable.baseline_video_camera_back_24,
            navController,
            viewModelClicked = {

            })

    }


}