package com.example.polarstardrivingassistance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.polarstardrivingassistance.ui.components.NavHostApp
import com.example.polarstardrivingassistance.ui.screens.MainFrame
import com.example.polarstardrivingassistance.ui.theme.PolarStarDrivingAssistanceTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //获取状态栏高度
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height","dimen","android")

        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }

        //让内容，显示在状态栏和系统导航栏后面：状态栏和导航栏会遮盖部分内容
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            PolarStarDrivingAssistanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainFrame(statusBarHeight)
                    NavHostApp(statusBarHeight)
                }
            }
        }
    }
}

