package com.hasancbngl.recepiapp.repository

import com.hasancbngl.recepiapp.network.RecipeApi
import com.hasancbngl.recepiapp.network.RecipeClient
import javax.inject.Inject

class RecipeRepository @Inject constructor(val client: RecipeClient) {
    fun getRecipes(): RecipeApi = client.api()
}