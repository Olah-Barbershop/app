package com.olahbarbershop.app.data

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val name: String,
    val route: String,
    @DrawableRes val iconUnSelected: Int,
    @DrawableRes val iconSelected: Int
)