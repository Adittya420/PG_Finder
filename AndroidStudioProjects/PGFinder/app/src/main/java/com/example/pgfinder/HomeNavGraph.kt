package com.example.pgfinder

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pgfinder.ui.theme.home


@Composable
fun HomeNavGraphOriginal(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.home,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            home(onReadClick ={
                navController.navigate(HomeNavGraph.ViewPG.route)
            })
        }
        composable(route = HomeNavGraph.ViewPG.route){
            MainFragment(PGdata())
        }

//        composable(route = )
//        composable(route = SettingNav.EditProf.route) {
//            EditProfileScreen(AutherViewModel())
//        }
//        composable(route = SettingNav.ViewProf.route) {
//            viewProf (
//                onEditClick = {
//                    navController.navigate(SettingNav.EditProf.route)
//                }
//                    )
//        }
        detailsNavGraph(navController = navController)
    }
}

sealed class HomeNavGraph(val route : String){
    object ViewPG : HomeNavGraph(route = "ViewPG")
//    object  : HomeNavGraph(route = "ViewPG")
}