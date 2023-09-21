package com.example.login1.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.login1.Components.BoldTextComponents
import com.example.login1.Components.ButtonComponent
import com.example.login1.Components.CheckBoxComponent
import com.example.login1.Components.ClickableLoginTextComponent
import com.example.login1.Components.DividerTextComponent
import com.example.login1.Components.Mytextfield
import com.example.login1.Components.NormalTextComponents
import com.example.login1.Components.passwordTextField
import com.example.login1.R
import com.example.login1.Utils.RegistrationViewModel
import com.example.login1.Utils.UiEvent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
){

    val snackBarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState)}
    ) {
        Column(
            modifier = Modifier.fillMaxSize().absolutePadding(10.dp,0.dp, 10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            NormalTextComponents(value = stringResource(id = R.string.Hello))

            BoldTextComponents(value = stringResource(id = R.string.create_account))

            Spacer(modifier = Modifier.heightIn(15.dp))

            Mytextfield(
                labelValue = stringResource(id = R.string.first_name),
                painterResource = painterResource(id = R.drawable.baseline_supervised_user_circle_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredName(it))
                })
            Spacer(modifier = Modifier.heightIn(15.dp))

            Mytextfield(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.baseline_man_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredLastName(it))
                })
            Spacer(modifier = Modifier.heightIn(15.dp))

            Mytextfield(
                labelValue = stringResource(id = R.string.Email),
                painterResource = painterResource(id = R.drawable.baseline_email_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredEmail(it))

                })
            Spacer(modifier = Modifier.heightIn(15.dp))

            passwordTextField(
                labelValue = stringResource(id = R.string.Password),
                painterResource = painterResource(id = R.drawable.baseline_password_24),
                onTextSelected = {
                    viewModel.onEvent(UiEvent.EnteredPassword(it))

                })
            Spacer(modifier = Modifier.heightIn(15.dp))
            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions), navController)
            Spacer(modifier = Modifier.heightIn(25.dp))
            ButtonComponent(value = "Register",
                onButtonClicked = {
                    viewModel.onEvent(UiEvent.RegisterButtonClicked)
                    scope.launch {
                        Log.d("snack", "entered")
                        val result = snackBarHostState.showSnackbar(
                            message = "Registration Done",
                            actionLabel = "Login"
                        )
                        Log.d("snack", "entered1")
                        if(result == SnackbarResult.ActionPerformed){
                            navController.navigate(Screen.LoginScreen.route)
                        }
                    }
                })

            Spacer(modifier = Modifier.height(10.dp))
            DividerTextComponent()

            Spacer(modifier = Modifier.height(10.dp))
            ClickableLoginTextComponent(navController = navController)
        }
    }
    

}

//@Preview(showBackground = true)
//@Composable
//fun new(){
//    LoginScreen(navController)
////    LoginScreen(navController = NavController(this))
//}