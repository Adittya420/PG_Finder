package com.example.pgfinder

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pgfinder.ui.theme.home

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            home()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            ProfileCardUI(
                onViewButtonClick = {
                    navController.navigate(Graph.Setings)
                },
                OnCustumisationClick = {
                    navController.navigate(Graph.editp)
                }

            )


//        }
//        composable(route = SettingNav.ViewProf.route){
//            viewProf(
//                onClick = {
//                    navController1.navigate(SettingNav.EditProf.route)
//                }
//            )
//        }
//
//        composable(route = SettingNav.EditProf.route){
//            EditProfileScreen()
//        }
//
        }
        composable(route = BottomBarScreen.Create.route){
            MyCreates()
        }
        detailsNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.Setings,
        startDestination = SettingNav.ViewProf.route
    ) {
        composable(route = SettingNav.ViewProf.route) {
            viewProf (
                AutherViewModel(),
//                onClick = {
//                    navController.navigate(SettingNav.EditProf.route)
//                }
            )

        }
//        composable(route = SettingNav.EditProf.route) {
//            EditProfileScreen(AutherViewModel())
//        }
    }
    navigation(
        route = Graph.editp,
        startDestination = SettingNav.EditProf.route
    ){
        composable(route = SettingNav.EditProf.route){
            EditProfileScreen(AutherViewModel())
        }
    }
}


sealed class SettingNav(val route: String) {
    //    object Login : AuthScreen(route = "LOGIN")
//    object SignUp : AuthScreen(route = "SIGN_UP")
    object ViewProf : SettingNav(route = "View")
    object EditProf : SettingNav(route = "Edit")
    object ViewButton : SettingNav(route = "sfs")
}



