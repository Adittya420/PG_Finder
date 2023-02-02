package com.example.pgfinder

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavTocreateGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.Create,
        startDestination = BottomBarScreen.Creates.route
    ) {
        composable(route = BottomBarScreen.Creates.route) {
            ToCreate(onCreateclick = {
                navController.navigate(CreateNav.CreatePG.route)
            })
        }
        composable(route = CreateNav.CreatePG.route){
            MyCreates(PGviewModel())
        }
    }
}

sealed class CreateNav(val route: String) {
    //    object Login : AuthScreen(route = "LOGIN")
//    object SignUp : AuthScreen(route = "SIGN_UP")
    object CreatePG : CreateNav(route = "Create")
//    object EditProf : SettingNav(route = "Edit")
//    object ViewButton : SettingNav(route = "sfs")
}