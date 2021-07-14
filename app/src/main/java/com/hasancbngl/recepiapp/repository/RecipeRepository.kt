package com.hasancbngl.recepiapp.repository

import com.hasancbngl.recepiapp.network.RecipeClient

class RecipeRepository(val client: RecipeClient) {
    fun getRecipes() = client.api
}