package com.example.polarstardrivingassistance.ui.screens

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.polarstardrivingassistance.model.entity.NavigationItem

object Pages{
    const val MainPage = "mainPage"
    const val RecordPage = "recordPage"
    const val PersonPage = "personPage"
}

@ExperimentalMaterial3Api
@Composable
fun MainFrame(
    statusBarHeight: Int,
    onNavigateToPersonDetail: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {


    val navigationItems = listOf(
        NavigationItem(title = "主页", icon = Icons.Default.Home,Pages.MainPage),
        NavigationItem(title = "违规记录", icon = Icons.Default.DateRange,Pages.RecordPage),
        NavigationItem(title = "我的", icon = Icons.Default.Person,Pages.PersonPage)
    )

    var currentSelect by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.navigationBarsPadding()
            ){
                navigationItems.forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        //设置当前项是否为选中
                        selected = currentSelect == index,
                        onClick = {
                            currentSelect = index
                        },
                        icon = {
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navigationItem.title)
                        }
                    )
                }
            }
        }
    ){innerPadding ->
        //IDE强制要使用者innerPadding,这里就简单的打印一下
        println(innerPadding)
        when (currentSelect) {
            0 -> MainScreen(statusBarHeight = statusBarHeight)
            1 -> RecordScreen(statusBarHeight = statusBarHeight)
            2 -> PersonScreen(
                statusBarHeight = statusBarHeight,
                onNavigateToPersonDetail = onNavigateToPersonDetail,
                onNavigateToLogin = onNavigateToLogin
            )
        }
    }
}


