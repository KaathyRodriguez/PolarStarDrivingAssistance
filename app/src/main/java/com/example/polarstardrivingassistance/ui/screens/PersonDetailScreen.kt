package com.example.polarstardrivingassistance.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module.webview.WebView
import com.example.module.webview.rememberWebViewState
import com.example.polarstardrivingassistance.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailScreen(onBack: () -> Unit) {
    
    val webViewState = rememberWebViewState(data = "<h1>Hea der</h1>")
    
    Scaffold(
        topBar = {
            TopAppBar(
               title = {
                   Text(
                       text = "个人信息",
                       modifier = Modifier.fillMaxWidth(),
                       textAlign = TextAlign.Center,
                       fontSize = 18.sp
                   )
               },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                onBack()
                            }
                            .size(24.dp)

                    )
                }
            )
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .statusBarsPadding()
    ) {
        Column(modifier = Modifier.padding(top = 50.dp)) {
            WebView(webViewState)
        }
    }
}

//@Preview
//@Composable
//fun PersonDetailScreenPreview() {
//    PersonDetailScreen()
//}