package com.example.polarstardrivingassistance.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.example.polarstardrivingassistance.viewmodel.UserViewModel

val LocalUserViewModel =
    compositionLocalOf<UserViewModel> { error("User view Model Context Not Found") }