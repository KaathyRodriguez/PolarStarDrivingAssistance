package com.example.polarstardrivingassistance.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.polarstardrivingassistance.ui.components.TopAppBar

@Composable
fun MainScreen(statusBarHeight: Int) {
    Column(modifier = Modifier) {
        TopAppBar(modifier = Modifier.padding(8.dp), statusBarHeight = statusBarHeight){

            //搜索按钮
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0xFFE6E6FA)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "搜索一下",
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }

            Text(text = "日期\n天气")

            Text(text = "2023/9/11\n  🌤  ")

            Icon(imageVector = Icons.Default.Notifications, contentDescription = null)

        }
    }
    Text(text = "功能主页")
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(30)
}