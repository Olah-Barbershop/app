package com.olahbarbershop.app.data

data class Location (
    val address: String,
    val phoneNumber: String,
    val mondayToThursday: String,
    val friday: String,
    val saturdayToSunday: String
)

val locationList = listOf(
    Location("Budapest, Lovasi tér 2, 1137", "+36/1-555-****", "8:00 - 16:00", "7:00 - 14:00", "Closed"),
    Location("Budaörs, Fazekas út 14, 2040", "+36/1-555-****", "8:00 - 18:00", "7:30 - 15:00", "Closed")
)