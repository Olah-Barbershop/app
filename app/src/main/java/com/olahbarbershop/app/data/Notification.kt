package com.olahbarbershop.app.data

import androidx.annotation.DrawableRes
import com.olahbarbershop.app.R

data class Notification(
    val id: String,
    @DrawableRes val imageResourceId: Int,
    val type: String,
    val posted: String,
    val description: String
)

val notificationList = listOf(
    Notification("random id", R.drawable._1000p, "News", "2023/04/30", "This is some exciting news!"),
    Notification("other random id", R.drawable._1000p, "Merch", "2023/03/05", "This is some exciting merch!")
)