package com.example.login1.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login1.Components.BoldTextComponents

@Composable
fun TermsandCondition(
    navController: NavController
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(15.dp)
    ) {
        BoldTextComponents(value = "Terms and Conditions")

    }
}

//@Preview
//@Composable
//fun TermsandConditionPreview(){
//    TermsandCondition()
//}