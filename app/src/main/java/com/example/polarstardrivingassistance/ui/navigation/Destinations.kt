package com.example.polarstardrivingassistance.ui.navigation

sealed class Destinations(val route: String){

    //首页大框架
    object HomeFrame: Destinations("HomeFrame")

    //登录页
    object LoginPage: Destinations("LoginPage")

    //个人信息页面
    object PersonDetail : Destinations("PersonDetail")
}


