package com.example.polarstardrivingassistance.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.polarstardrivingassistance.R
import com.example.polarstardrivingassistance.compositionLocal.LocalUserViewModel
import com.example.polarstardrivingassistance.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onClose: () -> Unit
) {

//    //屏幕宽度
//    var screenWidth: Float
//    //屏幕高度
//    var screenHeight: Float
//    with(LocalDensity.current) {
//        screenWidth = LocalConfiguration.current.screenWidthDp.dp.toPx()
//        screenHeight = LocalConfiguration.current.screenHeightDp.dp.toPx()
//    }

    val userViewModel = LocalUserViewModel.current

    val coroutineScope = rememberCoroutineScope()

    var showPassword by remember {
        mutableStateOf(false)
    }


    BoxWithConstraints(modifier = Modifier.fillMaxSize()){

        //背景图层
        Image(
            painter = painterResource(id = R.drawable.polar),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        //右上往左下渐变层
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xffbb8378), Color.Transparent),
                        start = Offset(x = constraints.maxWidth.toFloat(), y = 0f),
                        end = Offset(x = 0f, y = constraints.maxHeight.toFloat())
                    )
                )
        )

        //左下往右上渐变层
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf(Color(0xff000080), Color.Transparent),
                        start = Offset(x = 0f, y = constraints.maxHeight.toFloat()),
                        end = Offset(x = constraints.maxWidth.toFloat(), y = 0f)
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = "POLAR STAR",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
            
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                
                TextField(
                    value = userViewModel.userName,
                    onValueChange = { userViewModel.userName = it },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.people),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = "Username",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.LightGray,
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.Transparent,
                        focusedLabelColor = Color.LightGray,
                        unfocusedLabelColor = Color.LightGray,
                        cursorColor = Color.LightGray,
                        textColor = Color.White,
                        disabledTextColor = Color.White
                    ),
                    enabled = !userViewModel.loading
                )

                TextField(
                    value = userViewModel.password,
                    onValueChange = { userViewModel.password = it },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    trailingIcon = {
                        Icon(painter = if (showPassword) painterResource(id = R.drawable.visibility)
                            else painterResource(id = R.drawable.visibility_off),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    showPassword = !showPassword
                                }
                                .size(20.dp),
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = "Password",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.LightGray,
                        unfocusedIndicatorColor = Color.LightGray,
                        containerColor = Color.Transparent,
                        focusedLabelColor = Color.LightGray,
                        unfocusedLabelColor = Color.LightGray,
                        cursorColor = Color.LightGray,
                        textColor = Color.White,
                        disabledTextColor = Color.White
                    ),
                    enabled = !userViewModel.loading
                )
                
                Spacer(modifier = Modifier.padding(8.dp))
                
                TextButton(
                    onClick = {
                    coroutineScope.launch {
                        userViewModel.login(onClose = onClose)
                    }
                },
                    enabled = !userViewModel.loading
                ) {
                    Row {
                        Text(
                            text = "SIGN IN",
                            color = Color.White
                        )
                        if (userViewModel.loading) {
                            CircularProgressIndicator(modifier = Modifier.size(20.dp))
                        }
                    }
                }

                Text(text = userViewModel.error, color = Color.Red, fontSize = 13.sp)
                
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Don't have an account? Click to register now",
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
            }

        }
    }
}