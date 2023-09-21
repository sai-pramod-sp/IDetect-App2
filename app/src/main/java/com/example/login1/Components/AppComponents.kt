package com.example.login1.Components

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login1.R
import com.example.login1.Screens.Screen

@Composable
fun NormalTextComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(26.dp),
        style = TextStyle(
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal),
        color = Color.Black,
        textAlign =  TextAlign.Center
    )

}

@Composable
fun BoldTextComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp),
        style = TextStyle(
            fontStyle = FontStyle.Italic,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold),
        color = Color.Black,
        textAlign =  TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mytextfield(labelValue: String, painterResource: Painter,
                onTextSelected: (String) -> Unit){

    val textValue = remember{
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp),
        label = { Text(text = labelValue)},
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource,
                contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passwordTextField(labelValue: String, painterResource: Painter,
                      onTextSelected: (String) -> Unit){

    val password = remember{
        mutableStateOf("")
    }

    val passwordVisibility = remember{
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp),
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        label = {Text(text = labelValue)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(painter = painterResource,
                contentDescription = "")
        },
        trailingIcon = {
            val iconImage  = if(passwordVisibility.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }

            val description = if(passwordVisibility.value){
                "Hide password"
            }else{
                "Show password"
            }

            IconButton(
                onClick = {passwordVisibility.value=!passwordVisibility.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
    ) {
        val checkedState = remember{
            mutableStateOf(false)
        }

        Checkbox(
            checked =  checkedState.value,
            onCheckedChange ={
                checkedState.value != checkedState.value
            } )

        ClickableTextComponent(value = value, navController)
    }
}

@Composable
fun ClickableTextComponent(
    value: String,
    navController: NavController,
    ){
    val initialText = "By continuing you accept our "
    val privacyPolicy = "Privacy Policy "
    val andText = " and "
    val termsAndCondition = "terms and conditions"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = termsAndCondition, annotation = termsAndCondition)
            append(termsAndCondition)
        }
    }

    ClickableText(text = annotatedString, onClick = {navController.navigate(Screen.TermsandConditions.route)})
}

@Composable
fun ButtonComponent(
    value: String, onButtonClicked : () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp),
        onClick = {
            onButtonClicked.invoke()
        }
        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(40.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = value,
                fontSize = 18.sp)
        }

    }
    
}

@Composable
fun DividerTextComponent(){
    Row(
        modifier = Modifier.heightIn(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
        Text(modifier = Modifier.padding(8.dp), text = "or", color = Color.Black, fontSize = 18.sp)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

    }
}

@Composable
fun ClickableLoginTextComponent(
    navController: NavController,
){
    val initialText = "Already have an account? "
    val login = "Login "

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(26.dp),
        style = TextStyle(
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center),
        text = annotatedString,
        onClick = {navController.navigate(Screen.LoginScreen.route)})
}

@Composable
fun ClickableRegisterTextComponent(
    navController: NavController,
){
    val initialText = "Don't have an account? "
    val login = "Register here "

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Blue)){
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(26.dp),
        style = TextStyle(
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center),
        text = annotatedString,
        onClick = {navController.navigate(Screen.RegisterScreen.route)})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(toolbarTitle: String){

    TopAppBar(
        title = {
            Text(text = toolbarTitle,
                color = Color.White
            )
        },
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu,
                contentDescription = stringResource(R.string.menu),
                tint = Color.White)
        },
        actions = {
            Icon(imageVector = Icons.Filled.Logout,
                contentDescription = stringResource(R.string.logout),
                tint = Color.White)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Blue)
    )
}

@Composable
fun NavigationDrawer(){

    
}



