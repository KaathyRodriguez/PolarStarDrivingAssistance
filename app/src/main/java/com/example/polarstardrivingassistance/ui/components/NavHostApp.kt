package com.example.polarstardrivingassistance.ui.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.polarstardrivingassistance.compositionLocal.LocalUserViewModel
import com.example.polarstardrivingassistance.model.entity.NavigationItem
import com.example.polarstardrivingassistance.ui.navigation.Destinations
import com.example.polarstardrivingassistance.ui.screens.LoginScreen
import com.example.polarstardrivingassistance.ui.screens.MainFrame
import com.example.polarstardrivingassistance.ui.screens.MainScreen
import com.example.polarstardrivingassistance.ui.screens.Pages
import com.example.polarstardrivingassistance.ui.screens.PersonDetailScreen
import com.example.polarstardrivingassistance.ui.screens.PersonScreen
import com.example.polarstardrivingassistance.ui.screens.RecordScreen
import com.example.polarstardrivingassistance.viewmodel.UserViewModel
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * 导航控制器
 *
 */
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NavHostApp(
    statusBarHeight:Int
) {

    val navController = rememberNavController()

    CompositionLocalProvider( LocalUserViewModel provides UserViewModel()) {

        val userViewModel = LocalUserViewModel.current

        NavHost(navController = navController, startDestination = Destinations.HomeFrame.route) {

            composable(
                Destinations.HomeFrame.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                }
            ){
                MainFrame(
                    statusBarHeight=statusBarHeight,
                    onNavigateToPersonDetail = {
                        navController.navigate(Destinations.PersonDetail.route)
                    },
                    onNavigateToLogin = {
                        if (userViewModel.logged) {
                            //已登录
                        } else {
                            //未登录
                            navController.navigate(Destinations.LoginPage.route)

                        }
                    }
                )
            }

            composable(
                Destinations.LoginPage.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                }
            ) {
                LoginScreen{
                    navController.popBackStack()
                }
            }


            composable(
                Destinations.PersonDetail.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
                }
            ){
                PersonDetailScreen(onBack = {
                    navController.popBackStack()
                })
            }
        }
    }
}


@Preview
@Composable
fun NavHostAppPreview() {
    NavHostApp(30)
}

