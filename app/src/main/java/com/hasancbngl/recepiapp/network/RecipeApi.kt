package com.hasancbngl.recepiapp.network

import com.hasancbngl.recepiapp.model.Recipe
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import java.util.*
import kotlin.collections.ArrayList

interface RecipeApi {
    @GET("recipes.json")
    fun allRecipes(): Observable<ArrayList<Recipe>>
}