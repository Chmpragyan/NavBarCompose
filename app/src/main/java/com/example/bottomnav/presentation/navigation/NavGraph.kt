package com.example.bottomnav.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnav.presentation.screens.auth.AuthScreen
import com.example.bottomnav.presentation.screens.auth.MLKitQRScannerScreen
import com.example.bottomnav.presentation.screens.auth.SecurityCodeSignInScreen
import com.example.bottomnav.presentation.screens.dashboard.account.AccountScreen
import com.example.bottomnav.presentation.screens.dashboard.calls.CallsScreen
import com.example.bottomnav.presentation.screens.dashboard.contacts.ContactDetailScreen
import com.example.bottomnav.presentation.screens.dashboard.contacts.ContactsScreen
import com.example.bottomnav.presentation.screens.dashboard.keypad.KeypadScreen
import com.example.bottomnav.presentation.screens.dashboard.messages.MessageScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Auth.route) {
        // Auth screen route
        composable(Screen.Auth.route) {
            AuthScreen(navController)
        }
        composable(Screen.SecurityCodeSignIn.route) {
            SecurityCodeSignInScreen()
        }
        composable(Screen.MLKitQRScannerScreen.route) {
            MLKitQRScannerScreen()
        }

        // Navigation routes for bottom navigation screen
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

        // Details screen route
        composable(Screen.ContactDetail.route) {
            ContactDetailScreen()
        }
    }
}