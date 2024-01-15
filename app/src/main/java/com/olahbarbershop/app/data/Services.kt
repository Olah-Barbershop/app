package com.olahbarbershop.app.data

data class Service(
    val name: String,
    val description: String,
    val amount: Number
)

val services = listOf(
    Service("Normal Haircut", "Get a classic and stylish haircut that suits your preferences. Our skilled barbers will give you a trim, shape, and style that complements your look.", 5000),
    Service("Long Cut", "For those who love their locks, our long cut service is designed to maintain or update your longer hairstyle. Whether it's layers, texturing, or a simple trim, we've got you covered.", 7000),
    Service("One Length Cut", 	"Achieve a sleek and uniform look with our one length cut. Ideal for those who prefer a consistent length throughout their hair, this service ensures a clean and polished appearance.", 3000),
    Service("Shaving", "Experience the art of shaving with our professional barber services. Enjoy a precision shave, hot towel treatment, and soothing aftercare for a refreshed and clean finish.", 2500)
)