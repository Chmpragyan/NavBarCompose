package com.example.bottomnav.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnav.presentation.screens.account.AccountScreen
import com.example.bottomnav.presentation.screens.calls.CallsScreen
import com.example.bottomnav.presentation.screens.contacts.ContactDetailScreen
import com.example.bottomnav.presentation.screens.contacts.ContactsScreen
import com.example.bottomnav.presentation.screens.keypad.KeypadScreen
import com.example.bottomnav.presentation.screens.messages.MessageScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Calls.route) {
        composable(Screen.Calls.route) {
            CallsScreen(navController)
        }
        composable(Screen.Messages.route) {
            MessageScreen()
        }
        composable(Screen.Keypad.route) {
            KeypadScreen()
        }
        composable(Screen.Contacts.route) {
            ContactsScreen()
        }
        composable(Screen.Account.route) {
            AccountScreen()
        }
        composable(Screen.ContactDetail.route) {
            ContactDetailScreen()
        }
    }
}