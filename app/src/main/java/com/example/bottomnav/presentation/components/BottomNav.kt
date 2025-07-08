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

@Composable
fun BottomBar(navController: NavController) {
    val items = BottomNavItem.items

    NavigationBar(
        containerColor = colorResource(R.color.background),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                label = {
                    Text(
                        text = item.label,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(500)
                    )
                },
                selected = selected,
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.label,
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
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                ),
            )
        }
    }
}
