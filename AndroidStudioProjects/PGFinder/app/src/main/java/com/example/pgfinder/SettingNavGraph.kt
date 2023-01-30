package com.example.pgfinder

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.Setings,
        startDestination = BottomBarScreen.Settings.route
    ) {
        composable(route = BottomBarScreen.Settings.route) {
           ProfileCardUI(
               onViewButtonClick = {
                   navController.navigate(SettingNav.ViewProf.route)
               } ,
               OnCustumisationClick = {
                   navController.navigate(SettingNav.EditProf.route)
               }
           )
        }
//        composable(route = SettingNav.EditProf.route) {
//            EditProfileScreen(AutherViewModel())
//
//        }
//        composable(route = SettingNav.ViewProf.route) {
//            viewProf (
//                onEditClick = {
//                    navController.navigate(SettingNav.EditProf.route)
//                }
//                    )
//
//
//
//        }
        detailsNavGraph(navController = navController)
    }
}
