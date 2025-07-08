package com.example.bottomnav.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.CallsScreen.route){
        composable(BottomNavItem.CallsScreen.route){
            BottomNavItem.CallsScreen
        }
        composable(BottomNavItem.MessageScreen.route){
            BottomNavItem.MessageScreen
        }
        composable(BottomNavItem.KeypadScreen.route){
            BottomNavItem.KeypadScreen
        }
        composable(BottomNavItem.ContactsScreen.route){
            BottomNavItem.ContactsScreen
        }
        composable(BottomNavItem.AccountScreen.route){
            BottomNavItem.AccountScreen
        }
    }
}