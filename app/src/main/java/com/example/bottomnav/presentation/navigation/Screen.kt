package com.example.bottomnav.presentation.navigation

sealed class Screen(val route: String) {
    object Calls: Screen("calls_screen")
    object Messages: Screen("messages_screen")
    object Keypad: Screen("keypad_screen")
    object Contacts: Screen("contacts_screen")
    object Account: Screen("account_screen")
}