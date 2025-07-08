package com.example.bottomnav.presentation.navigation

import androidx.annotation.DrawableRes
import com.example.bottomnav.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String
) {
    object CallsScreen : BottomNavItem("calls_screen", R.drawable.ic_call_nav_unselected, "Calls")
    object MessageScreen : BottomNavItem("calls_screen", R.drawable.ic_message_nav_unselected, "Messages")
    object KeypadScreen : BottomNavItem("calls_screen", R.drawable.ic_keypad_nav_unselected, "Keypad")
    object ContactsScreen : BottomNavItem("calls_screen", R.drawable.ic_contact_nav_unselected, "Contacts")
    object AccountScreen : BottomNavItem("calls_screen", R.drawable.ic_account_nav_unselected, "Account")

    companion object {
        val items = listOf(CallsScreen, MessageScreen, KeypadScreen, ContactsScreen, AccountScreen)
    }
}
