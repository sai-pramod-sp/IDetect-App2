package com.example.login1.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login1.Components.BoldTextComponents
import com.example.login1.Components.ButtonComponent
import com.example.login1.Components.ClickableRegisterTextComponent
import com.example.login1.Components.DividerTextComponent
import com.example.login1.Components.Mytextfield
import com.example.login1.Components.NormalTextComponents
import com.example.login1.Components.passwordTextField
import com.example.login1.R
import com.example.login1.Utils.LoginUiState
import com.example.login1.Utils.LoginViewModel
import com.example.login1.Utils.UiEvent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){
    val snackBarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().absolutePadding(10.dp, 0.dp, 10.dp),
            verticalArrangement = Arrangement.Center,

        ) {
            NormalTextComponents(value = stringResource(id = R.string.Hello))

            BoldTextComponents(value = stringResource(id = R.string.welcome_back))

            Spacer(modifier = Modifier.height(15.dp))

            Mytextfield(
                labelValue = stringResource(id = R.string.Email),
                painterResource = painterResource(id = R.drawable.baseline_email_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredEmail(it))

                }
            )
            Spacer(modifier = Modifier.heightIn(15.dp))

            passwordTextField(
                labelValue = stringResource(id = R.string.Password),
                painterResource = painterResource(id = R.drawable.baseline_password_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredPassword(it))
                }
            )

            Spacer(modifier = Modifier.height(50.dp))

            ButtonComponent(value = "Login",
                onButtonClicked = {

                    if (viewModel.isValidationPassed.value){
                        navController.navigate(Screen.HomeScreen.route)
                        viewModel.isValidationPassed.value = false
                    }else{
                        Log.d("passedSnack", ""+viewModel.isValidationPassed.value)
                        scope.launch {
                            snackBarHostState.showSnackbar(
                                message = "Details are invalid! Please enter correct details"
                            )
                        }
                    }

                })
            DividerTextComponent()
            Spacer(modifier = Modifier.height(30.dp))
            
            ClickableRegisterTextComponent(navController = navController)
        }



    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(navController = rememberNavController())
}