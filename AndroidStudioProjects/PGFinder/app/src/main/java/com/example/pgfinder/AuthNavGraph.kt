package com.example.pgfinder

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Graph.HOME)
                },
                onSignupClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )
                }


        }
        composable(route = AuthScreen.SignUp.route) {
           RegisterScreen()
        }
//    composable(route = AuthScreen.EditProf.route){
//        EditProfileScreen()
//    }
//    composable(route = AuthScreen.ViewProf.route){
//        viewProf(
//            onEditClick = {
//                navController.navigate(AuthScreen.ViewProf.route)
//            }
//        )
//    }
//    composable(route = AuthScreen.ViewButton.route ){
//        ProfileCardUI(
//            onViewButtonClick = {
//                navController.navigate(AuthScreen.ViewProf.route)
//            }
//        )
//    }
//        composable(route = AuthScreen.Forgot.route) {
//            ScreenContent(name = AuthScreen.Forgot.route) {}
//        }
    }


sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
//    object ViewProf : AuthScreen(route = "SIGN_UP")
//    object EditProf : AuthScreen(route = "FORGOT")
//    object ViewButton : AuthScreen(route = "FORGOT")
}