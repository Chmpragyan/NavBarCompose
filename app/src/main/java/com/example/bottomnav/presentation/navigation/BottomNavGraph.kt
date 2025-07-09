package com.example.bottomnav.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Calls.route){
        composable(Screen.Calls.route){
            Screen.Calls
        }
        composable(Screen.Messages.route){
            Screen.Messages
        }
        composable(Screen.Keypad.route){
            Screen.Keypad
        }
        composable(Screen.Contacts.route){
            Screen.Contacts
        }
        composable(Screen.Account.route){
            Screen.Account
        }
    }
}