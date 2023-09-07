package com.example.polarstardrivingassistance.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.polarstardrivingassistance.ui.components.TopAppBar

@Composable
fun RecordScreen(statusBarHeight: Int) {
    Column(modifier = Modifier) {
        TopAppBar(statusBarHeight = statusBarHeight){
            Text(text = "违规记录")
        }
    }
    Text(text = "违规记录")
}

@Preview
@Composable
fun RecordScreenPreview() {
    RecordScreen(statusBarHeight = 30)
}