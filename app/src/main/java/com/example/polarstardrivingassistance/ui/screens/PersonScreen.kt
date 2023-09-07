package com.example.polarstardrivingassistance.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.polarstardrivingassistance.R
import com.example.polarstardrivingassistance.ui.components.TopAppBar

@Composable
fun PersonScreen(
    statusBarHeight: Int,
    onNavigateToPersonDetail: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {

    val menus = listOf(
        MenuItem(R.drawable.people,"个人资料"),
        MenuItem(R.drawable.mail,"邮箱消息"),
        MenuItem(R.drawable.video,"回放"),
        MenuItem(R.drawable.setup,"设置"),
        MenuItem(R.drawable.questions,"常见问题")
    )

    Column(modifier = Modifier) {
        TopAppBar(statusBarHeight = statusBarHeight){
            Text(text = "个人中心", fontSize = 18.sp)
        }
        LazyColumn(modifier = Modifier.padding(8.dp)){
            //头像部分
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 24.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.head),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .height(62.dp)
                    ) {
                        Text(
                            text = "登录/注册",
                            color = Color(0xFF333333),
                            fontSize = 18.sp,
                            modifier = Modifier.clickable {
                                onNavigateToLogin()
                        })
                    }
                }
            }

            //菜单部分
            items(menus) { menu ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {

                    Icon(
                        painter = painterResource(id = menu.icon),
                        contentDescription = null,
                        modifier = Modifier.size(17.dp)
                    )

                    
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                           Text(
                               text =menu.title,
                               color = Color(0xFF333333),
                               fontSize = 16.sp,
                               modifier = Modifier.weight(1f)
                           )
                            Icon(
                                painter = painterResource(id = R.drawable.enter),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(13.dp)
                                    .clickable {
                                        when (menu.title) {
                                            "个人资料" -> onNavigateToPersonDetail.invoke()
                                            else -> null
                                        }
                                    }
                            )
                        }
                        
                    }
                }
            }
        }
    }
}

data class MenuItem(@DrawableRes val icon: Int, val title: String)


@Preview
@Composable
fun PersonScreenPreview() {
    PersonScreen(statusBarHeight = 30)
}