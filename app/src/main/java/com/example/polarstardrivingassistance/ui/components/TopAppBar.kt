package com.example.polarstardrivingassistance.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * 统一标题栏
 *
 * @param modifier
 * @param statusBarHeight 状态栏高度
 * @param content 标题栏内容
 */
@Composable
fun TopAppBar(modifier:Modifier = Modifier, statusBarHeight:Int,content: @Composable ()->Unit) {

    val systemUiController = rememberSystemUiController()

    LaunchedEffect(key1 = Unit){
        systemUiController.setStatusBarColor(Color.Transparent)
    }

    //标题栏高度
    val appBarHeight = 56.dp

    //转换状态栏高度 px 为dp
    val statusBarHeightDp = with(LocalDensity.current) {
        statusBarHeight.toDp()
    }

    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(statusBarHeight = 30){
        Text(text = "标题")
    }
}