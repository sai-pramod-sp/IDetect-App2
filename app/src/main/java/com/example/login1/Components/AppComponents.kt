package com.example.login1.Components

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.net.Uri
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.login1.R
import com.example.login1.Screens.DrawerScreens
import com.example.login1.Screens.Screen
import com.example.login1.Utils.NavigationItems
import kotlinx.coroutines.launch


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
fun AppTopBar(toolbarTitle: String,
              logoutButtonClicked : () -> Unit,
              navigationButtonClicked: () -> Unit){

    TopAppBar(
        title = {
            Text(text = toolbarTitle,
                color = Color.Green
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { navigationButtonClicked.invoke() }
            ) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.menu),
                    tint = Color.Green)
            }

        },
        actions = {
            IconButton(
                onClick = { logoutButtonClicked.invoke() }
            ) {
                Icon(imageVector = Icons.Filled.Logout,
                    contentDescription = stringResource(R.string.logout),
                    tint = Color.Green)
            }

        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Blue)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBar(navController: NavController){
//    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember{
        mutableIntStateOf(0)
    }

    BottomAppBar(
        containerColor = Color.Blue
    ) {
        IconButton(
            onClick = {
                selected.intValue = 1
                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(0)
                }
            }, modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.Home,
                contentDescription = "None",
                modifier = Modifier.size(26.dp),
                tint = if (selected.intValue == 1) Color.White else Color.Green)
        }
        IconButton(
            onClick = {
                selected.intValue = 2
                navController.navigate(DrawerScreens.Favourites.route){
                    popUpTo(0)
                }
            }, modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "None",
                modifier = Modifier.size(26.dp),
                tint = if (selected.intValue == 2) Color.White else Color.Green)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Open BOx", Toast.LENGTH_LONG).show()
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "None")
            }
        }
        IconButton(
            onClick = {
                selected.intValue = 3
                navController.navigate(DrawerScreens.Cart.route){
                    popUpTo(0)
                }
            }, modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart,
                contentDescription = "None",
                modifier = Modifier.size(26.dp),
                tint = if (selected.intValue == 3) Color.White else Color.Green)
        }
        IconButton(
            onClick = {
                selected.intValue = 4
                navController.navigate(DrawerScreens.Settings.route){
                    popUpTo(0)
                }
            }, modifier = Modifier.weight(1f)
        ) {
            Icon(imageVector = Icons.Default.Person,
                contentDescription = "None",
                modifier = Modifier.size(26.dp),
                tint = if (selected.intValue == 4) Color.White else Color.Green)
        }
    }


}

@Composable
fun NavigationDrawerHeader(){
    Box(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    listOf(Color.White, Color.White)
                )
            )
            .fillMaxWidth(40F)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.eye), contentDescription = "image")
        //BoldTextComponents(value = stringResource(id = R.string.IDetect))
    }
}

@Composable
fun NavigationDrawerBody(navigationItems: List<NavigationItems>, navController: NavController){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(navigationItems){ it ->
            NavigationItemRow(items = it,
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
                })
        }
    }
}

@Composable
fun NavigationItemRow(items: NavigationItems, navigationItemClicked:(NavigationItems) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(30.dp)
            .clickable {
                navigationItemClicked.invoke(items)
            }
    ) {
        Icon(
            imageVector = items.image,
            contentDescription = items.description,
        )

        Spacer(modifier = Modifier.width(18.dp))

//        NavigationDrawerText(title = items.title)
        Text(
            text = items.title, style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
            )
        )

    }
}

@Composable
fun NavigationDrawerText(title: String) {
    val shadowOffset = Offset(4f, 6f)

    Text(
        text = title, style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
            shadow = Shadow(
                color = Color.Black,
                offset = shadowOffset, 2f
            )
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetectFragment(title: String, state: DrawerState, drawable: Int, navController: NavController, viewModelClicked: () -> Unit){

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current.applicationContext


    var itemType by remember{
        mutableIntStateOf(0)
    }

    itemType = when (title) {
        "Image Detection" -> 1
        "Video Detection" -> 2
        else -> 3
        }

    var defaultImageUriImage: Uri = when (title){
        "Image Detection" -> Uri.parse("android.resource://${context.packageName}/${R.drawable.baseline_image_search_24}")
        "Video Detection" -> Uri.parse("android.resource://${context.packageName}/${R.drawable.baseline_video_camera_back_24}")
        else -> Uri.parse("android.resource://${context.packageName}/${R.drawable.baseline_live_tv_24}")
    }

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(defaultImageUriImage)
    }


    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(

        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri }
    )

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
                        state.apply {
                            if(isClosed) open() else close()
                        }
                    }
                }
            )
        },
        bottomBar = {
            AppBottomBar(navController)
        }
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .absolutePadding(50.dp, 100.dp, 50.dp, 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = title, style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            AsyncImage(
                model = selectedImageUri,
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.heightIn(10.dp))
            Row {
                Button(
                    onClick = {
                              singlePhotoPickerLauncher.launch(
                                  PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                              )
                    },
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





