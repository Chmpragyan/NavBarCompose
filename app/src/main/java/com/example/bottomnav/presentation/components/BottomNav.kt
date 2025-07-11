package com.example.bottomnav.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bottomnav.R
import com.example.bottomnav.presentation.navigation.BottomNavItem
import com.example.bottomnav.presentation.navigation.Screen

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
        selectedIcon = R.drawable.ic_acount_nav_selected,
        unSelectedIcon = R.drawable.ic_account_nav_unselected,
        label = "Account"
    )

)

@Composable
fun BottomNav(navController: NavController) {

    NavigationBar(
        containerColor = colorResource(R.color.background),
        contentColor = colorResource(R.color.background),
//        modifier = Modifier.height(48.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationItems.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        BottomNavIcon(
                            selected = selected,
                            selectedIcon = item.selectedIcon,
                            unSelectedIcon = item.unSelectedIcon,
                            contentDescription = item.label
                        )
                        Text(
                            text = item.label,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = if (selected) FontWeight.W500 else FontWeight.W400,
                            color = if (selected) {
                                colorResource(R.color.on_primary)
                            } else colorResource(R.color.on_surface_variant)
                        )
                    }
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

@Composable
fun BottomNavIcon(
    selected: Boolean,
    selectedIcon: Int,
    unSelectedIcon: Int,
    contentDescription: String
) {
    val indicatorColor = colorResource(R.color.primary)

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp))
                    .background(indicatorColor)
            )
        }

        Icon(
            painter = painterResource(id = if (selected) selectedIcon else unSelectedIcon),
            contentDescription = contentDescription,
            tint = if (selected) colorResource(R.color.on_primary) else colorResource(R.color.on_surface_variant),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
