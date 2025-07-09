package com.example.bottomnav.presentation.navigation

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val route: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int,
    val label: String
)
