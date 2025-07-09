package com.example.bottomnav.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bottomnav.R
import com.example.bottomnav.presentation.navigation.BottomNavItem
import com.example.bottomnav.presentation.navigation.Screen

@Composable
fun BottomBar(navController: NavController) {
    val navigationItems = listOf(
        BottomNavItem(
            route = Screen.Calls.route,
            selectedIcon = R.drawable.ic_call_nav_selected,
            unSelectedIcon = R.drawable.ic_call_nav_unselected,
            label = "Calls",
        ),
        BottomNavItem(
            route = Screen.Messages.route,
            selectedIcon = R.drawable.ic_message_nav_selected,
            unSelectedIcon = R.drawable.ic_message_nav_unselected,
            label = "Messages"
        ),
        BottomNavItem(
            route = Screen.Keypad.route,
            selectedIcon = R.drawable.ic_keypad_nav_selected,
            unSelectedIcon = R.drawable.ic_keypad_nav_unselected,
            label = "Keypad"
        ),
        BottomNavItem(
            route = Screen.Contacts.route,
            selectedIcon = R.drawable.ic_contact_nav_selected,
            unSelectedIcon = R.drawable.ic_contact_nav_unselected,
            label = "Contacts"
        ),
        BottomNavItem(
            route = Screen.Account.route,
            selectedIcon = R.drawable.ic_account_nav_unselected,
            unSelectedIcon = R.drawable.ic_account_nav_unselected,
            label = "Account"
        )

    )

    NavigationBar(
        containerColor = colorResource(R.color.background),
        contentColor = colorResource(R.color.background)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationItems.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                label = {
                    Text(
                        text = item.label,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = if (selected) FontWeight.W600 else FontWeight.W500,
                        color = if (selected) {
                            colorResource(R.color.on_primary)
                        } else colorResource(R.color.on_surface_variant)
                    )
                },
                selected = selected,
                icon = {
                    Icon(
                        painterResource(id = if (selected) item.selectedIcon else item.unSelectedIcon),
                        contentDescription = item.label,
                        tint = if (selected) colorResource(R.color.on_primary) else colorResource(R.color.on_surface_variant),
                    )
                },
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                ),
            )
        }
    }
}
