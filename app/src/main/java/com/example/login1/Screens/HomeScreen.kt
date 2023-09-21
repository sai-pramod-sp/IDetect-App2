package com.example.login1.Screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login1.Components.AppTopBar
import com.example.login1.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
){

    Scaffold{
        AppTopBar(toolbarTitle = stringResource(id = R.string.IDetect))

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}