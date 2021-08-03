package com.hasancbngl.recepiapp.model

data class Recipe(
    val name: String,
    val ingredients: ArrayList<Ingredient>,
    val steps: ArrayList<String>,
    val timers: ArrayList<Int>,
    val imageURL: String,
    val originalUrl: String
)