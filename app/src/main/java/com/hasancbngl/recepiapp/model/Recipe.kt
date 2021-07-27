package com.hasancbngl.recepiapp.model

data class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val steps: List<String>,
    val timers: List<String>,
    val imageUrl: String,
    val originalUrl: String
) {
}