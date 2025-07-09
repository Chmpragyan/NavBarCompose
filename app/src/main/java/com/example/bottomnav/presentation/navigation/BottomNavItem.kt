package com.example.bottomnav.presentation.navigation

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String
)
