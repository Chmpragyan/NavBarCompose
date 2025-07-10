package com.example.bottomnav.domain.model

import androidx.annotation.DrawableRes

data class CallLog(
    @DrawableRes val icon: Int,
    val name: String,
    val date: String
)
