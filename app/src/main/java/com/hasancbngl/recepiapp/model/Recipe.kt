package com.hasancbngl.recepiapp.model

data class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val steps: List<String>,
    val timers: List<Int>,
    val imageURL: String,
    val originalUrl: String
)