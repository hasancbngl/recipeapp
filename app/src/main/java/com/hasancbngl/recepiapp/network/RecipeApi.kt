package com.hasancbngl.recepiapp.network

import com.hasancbngl.recepiapp.model.Recipe
import dagger.Binds
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import javax.inject.Inject


interface RecipeApi {
    @GET("recipes.json")
    fun allRecipes(): Observable<List<Recipe>>
}