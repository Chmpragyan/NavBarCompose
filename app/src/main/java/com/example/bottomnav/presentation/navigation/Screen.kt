package com.example.bottomnav.presentation.navigation

sealed class Screen(val route: String, val title: String = "") {
    // Auth
    object Auth : Screen("auth_screen")

    //Bottom Navigation
    object Calls : Screen("calls_screen", "Calls")
    object Messages : Screen("messages_screen", "Messages")
    object Keypad : Screen("keypad_screen")
    object Contacts : Screen("contacts_screen", "Contacts")
    object Account : Screen("account_screen", "Account")

    // Detail Screen
    object ContactDetail : Screen("contactDetail_screen")
}