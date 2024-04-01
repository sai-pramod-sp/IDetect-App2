package com.example.login1.Screens

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login1.Components.DetectFragment
import com.example.login1.Components.NavigationDrawerBody
import com.example.login1.Components.NavigationDrawerHeader
import com.example.login1.Components.DetectFragment
import com.example.login1.R
import com.example.login1.Utils.HomeViewModel
import com.example.login1.Utils.ViewModels.ImageDetectViewModle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(
    navController: NavController,
    viewModel: ImageDetectViewModle = hiltViewModel()
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

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
        
        DetectFragment(
            title = stringResource(id = R.string.imageDetect),
            drawerState,
            drawable = R.drawable.baseline_image_search_24,
            navController,
            viewModelClicked = {

            })

    }

}

@Preview
@Composable
fun ImageScreenPreview(){
    ImageScreen(navController = rememberNavController())
}